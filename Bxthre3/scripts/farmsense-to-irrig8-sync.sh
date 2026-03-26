#!/usr/bin/env bash
#
# farmsense-to-irrig8-sync.sh — Bxthre3 Brand Canonicalization Script
# Purpose: Simultaneous find-replace + agent instruction lock to prevent
#          Irrig8 re-contamination in the agent generation loop.
# Run: bash /home/workspace/Bxthre3/scripts/farmsense-to-irrig8-sync.sh
# =====================================================================

set -euo pipefail

LOG="/home/workspace/Bxthre3/logs/farmsense-sync-$(date +%Y%m%d-%H%M%S).log"
mkdir -p /home/workspace/Bxthre3/logs

exec > >(tee -a "$LOG") 2>&1

echo "=========================================="
echo "Bxthre3 Irrig8→Irrig8 Canonicalization"
echo "Started: $(date -u)"
echo "=========================================="

# ──────────────────────────────────────────────
# PHASE 1: FIND & REPLACE — ALL SOURCE FILES
# ──────────────────────────────────────────────
echo ""
echo "[PHASE 1] Scanning and replacing Irrig8 → Irrig8 across all source files..."

COUNT=$(grep -rl "Irrig8" /home/workspace/Bxthre3 --include="*.md" --include="*.tsx" --include="*.ts" --include="*.py" --include="*.sh" --include="*.html" 2>/dev/null | wc -l)
echo "→ Found $COUNT files containing Irrig8"

# Dry-run first so we can see what will change
echo ""
echo "Files to be modified:"
grep -rl "Irrig8" /home/workspace/Bxthre3 --include="*.md" --include="*.tsx" --include="*.ts" --include="*.py" --include="*.sh" --include="*.html" 2>/dev/null | sort

echo ""
echo "Replacing in place (sed -i)..."
# Replace patterns:
# 1. "Irrig8" alone → "Irrig8"
# 2. "farmsense-code" directory reference → "irrig8-code" (leave actual dir for archive)
# 3. "Irrig8 OS" → "Irrig8 OS"
# 4. "((retired brand))" → "(retired brand)"
# 5. "Irrig8 (irrig8)" → "Irrig8"
# 6. "Irrig8 API" → "Irrig8 API"
# 7. "Irrig8 Frontend" → "Irrig8 Frontend"
# 8. "Irrig8" (all lowercase) → "Irrig8"

grep -rl "Irrig8" /home/workspace/Bxthre3 --include="*.md" --include="*.tsx" --include="*.ts" --include="*.py" --include="*.sh" --include="*.html" 2>/dev/null | while read -r file; do
  echo "  Editing: $file"
  sed -i \
    -e 's/Irrig8 (irrig8)/Irrig8/g' \
    -e 's/Irrig8 ((retired brand))/Irrig8/g' \
    -e 's/Irrig8 (formerly)/Irrig8 (formerly)/g' \
    -e 's/((retired brand))/(retired brand)/g' \
    -e 's/Irrig8 API/Irrig8 API/g' \
    -e 's/Irrig8 Frontend/Irrig8 Frontend/g' \
    -e 's/Irrig8 OS/Irrig8 OS/g' \
    -e 's/Irrig8$/Irrig8/g' \
    -e 's/Irrig8,/Irrig8,/g' \
    -e 's/Irrig8)/Irrig8)/g' \
    -e 's/Irrig8-/Irrig8-/g' \
    -e 's/Irrig8\/Irrig8\//g' \
    -e "s/Irrig8's/Irrig8's/g" \
    -e 's/Irrig8/Irrig8/g' \
    -e 's/Irrig8/irrig8/g' \
    "$file"
done

echo ""
echo "[PHASE 1] Verification — checking remaining Irrig8 references:"
REMAINING=$(grep -r "Irrig8" /home/workspace/Bxthre3 --include="*.md" --include="*.tsx" --include="*.ts" --include="*.py" --include="*.sh" --include="*.html" 2>/dev/null | grep -v "ARCHIVED\|farmsense-code\|farmsense-portal\|Irrig8 retired\|(retired brand)\|retired Irrig8" | wc -l)
if [ "$REMAINING" -gt 0 ]; then
  echo "⚠️  WARNING: $REMAINING Irrig8 references remain:"
  grep -rn "Irrig8" /home/workspace/Bxthre3 --include="*.md" --include="*.tsx" --include="*.ts" --include="*.py" --include="*.sh" --include="*.html" 2>/dev/null | grep -v "ARCHIVED\|farmsense-code\|farmsense-portal\|Irrig8 retired\|(retired brand)\|retired Irrig8" | head -20
else
  echo "✅ Phase 1 clean — zero Irrig8 references in active files"
fi

# ──────────────────────────────────────────────
# PHASE 2: AGENT INSTRUCTION LOCK
# Prevent agents from writing Irrig8 back into generated files
# ──────────────────────────────────────────────
echo ""
echo "[PHASE 2] Locking agent instructions — adding Irrig8 guardrails..."

AGENT_INSTRUCTIONS=(
  "/home/workspace/Bxthre3/INBOX/agents/drew.md"
  "/home/workspace/Bxthre3/INBOX/agents/iris.md"
  "/home/workspace/Bxthre3/INBOX/agents/chronicler.md"
  "/home/workspace/Bxthre3/INBOX/agents/sentinel.md"
)

add_guardrail() {
  local file="$1"
  if [ -f "$file" ]; then
    # Check if guardrail already exists
    if grep -q "Irrig8 is retired" "$file" 2>/dev/null; then
      echo "  → Guardrail already present: $(basename "$file")"
    else
      echo "  → Adding guardrail: $(basename "$file")"
      # Append guardrail to top of notes section or end of file
      echo "" >> "$file"
      echo "---" >> "$file"
      echo "## BRAND COMPLIANCE (auto-inserted by farmsense-to-irrig8-sync.sh)" >> "$file"
      echo "**Irrig8 was retired 2026-03-23. Use ONLY 'Irrig8' as the product name.**" >> "$file"
      echo "- NEVER write 'Irrig8' in generated reports, briefs, or updates" >> "$file"
      echo "- If reading a file that contains 'Irrig8', treat it as stale/outdated" >> "$file"
      echo "- Always canonicalize to 'Irrig8' before writing output" >> "$file"
    fi
  fi
}

for agent_file in "${AGENT_INSTRUCTIONS[@]}"; do
  add_guardrail "$agent_file"
done

# Also update Drew's sprint template instructions if it exists
SPRINT_BRIEF="/home/workspace/Bxthre3/sprints/ON-2026-03-26/BRIEF.md"
if [ ! -f "$SPRINT_BRIEF" ]; then
  SPRINT_BRIEF="/home/workspace/Bxthre3/sprints/ON-2026-03-25/BRIEF.md"
fi
if [ -f "$SPRINT_BRIEF" ]; then
  add_guardrail "$SPRINT_BRIEF"
fi

# ──────────────────────────────────────────────
# PHASE 3: PROJECT_MANIFEST — canonical fix
# ──────────────────────────────────────────────
echo ""
echo "[PHASE 3] Fixing PROJECT_MANIFEST.md (primary contamination source)..."

if [ -f /home/workspace/Bxthre3/PROJECT_MANIFEST.md ]; then
  sed -i \
    -e 's/| \*\*Irrig8 (irrig8)/| **Irrig8/g' \
    -e 's/Irrig8 (irrig8)/Irrig8/g' \
    -e 's/Irrig8 API/Irrig8 API/g' \
    -e 's/Irrig8 Frontend/Irrig8 Frontend/g' \
    -e 's/Irrig8 (irrig8)/Irrig8/g' \
    /home/workspace/Bxthre3/PROJECT_MANIFEST.md
  echo "  → PROJECT_MANIFEST.md updated"
fi

# ──────────────────────────────────────────────
# PHASE 4: CHANNEL README — canonical fix
# ──────────────────────────────────────────────
echo ""
echo "[PHASE 4] Fixing channel/README.md..."

if [ -f /home/workspace/Bxthre3/channel/README.md ]; then
  sed -i \
    -e 's/Irrig8)/Irrig8)/g' \
    -e 's/((retired brand))/(retired brand)/g' \
    /home/workspace/Bxthre3/channel/README.md
  echo "  → channel/README.md updated"
fi

# ──────────────────────────────────────────────
# PHASE 5: GRANT RECORDS — canonical fix
# ──────────────────────────────────────────────
echo ""
echo "[PHASE 5] Fixing grant records..."

for f in /home/workspace/Bxthre3/grants/BATCH-01-FED-US.md \
         /home/workspace/Bxthre3/grants/BATCH-05-AFRICA-INTL.md \
         /home/workspace/Bxthre3/grants/records/FED-US-001.md \
         /home/workspace/Bxthre3/grants/records/FED-US-010.md \
         /home/workspace/Bxthre3/grants/records/FED-US-020.md \
         /home/workspace/Bxthre3/grants/records/INT-AS-004.md; do
  if [ -f "$f" ]; then
    sed -i 's/Irrig8/Irrig8/g' "$f"
    echo "  → $(basename "$f")"
  fi
done

# ──────────────────────────────────────────────
# PHASE 6: IRRIG8 PROJECT README + TODO
# ──────────────────────────────────────────────
echo ""
echo "[PHASE 6] Fixing the-irrig8-project canonical docs..."

for f in /home/workspace/Bxthre3/projects/the-irrig8-project/README.md \
         /home/workspace/Bxthre3/projects/the-irrig8-project/todo.md; do
  if [ -f "$f" ]; then
    sed -i \
      -e 's/# Irrig8 Project:/# Irrig8 Project:/g' \
      -e 's/# Irrig8 OS/Irrig8 OS/g' \
      -e 's/Irrig8$/Irrig8/g' \
      -e 's/Irrig8 Project/Irrig8 Project/g' \
      "$f"
    echo "  → $(basename "$f")"
  fi
done

# ──────────────────────────────────────────────
# PHASE 7: IRRIG8 PROJECT SKILLS (orphaned)
# ──────────────────────────────────────────────
echo ""
echo "[PHASE 7] Checking/fixing orphaned the-irrig8-project/Skills/..."

IRRIG8_SKILLS_DIR="/home/workspace/Bxthre3/projects/the-irrig8-project/Skills"
if [ -d "$IRRIG8_SKILLS_DIR" ]; then
  echo "  → Found orphaned Skills dir at $IRRIG8_SKILLS_DIR"
  echo "  → Contents:"
  ls "$IRRIG8_SKILLS_DIR/"
  echo "  → These skills should be migrated to Bxthre3/workspace/Skills/ or archived"
  echo "  → Migrating skill SKILL.md files now..."
  for skill_dir in "$IRRIG8_SKILLS_DIR"/*/; do
    if [ -d "$skill_dir" ] && [ -f "${skill_dir}SKILL.md" ]; then
      skill_name=$(basename "$skill_dir")
      echo "    Checking skill: $skill_name"
      # Check for Irrig8 references in the skill
      if grep -q "Irrig8" "${skill_dir}SKILL.md" 2>/dev/null; then
        sed -i 's/Irrig8/Irrig8/g' "${skill_dir}SKILL.md"
        echo "      → Cleaned Irrig8 references in $skill_name"
      fi
    fi
  done
else
  echo "  → No orphaned Skills dir found"
fi

# ──────────────────────────────────────────────
# FINAL VERIFICATION
# ──────────────────────────────────────────────
echo ""
echo "=========================================="
echo "[FINAL VERIFICATION]"
echo "=========================================="

echo ""
echo "Active files still containing Irrig8:"
REMAINING_ACTIVE=$(grep -rl "Irrig8" /home/workspace/Bxthre3 \
  --include="*.md" --include="*.tsx" --include="*.ts" --include="*.py" --include="*.sh" \
  2>/dev/null | grep -v "ARCHIVED\|farmsense-code\|farmsense-portal\|Irrig8 retired\|(retired brand)\|retired Irrig8" | sort)
if [ -z "$REMAINING_ACTIVE" ]; then
  echo "✅ ZERO active files contain Irrig8 — CLEAN"
else
  echo "⚠️  Remaining active Irrig8 references:"
  echo "$REMAINING_ACTIVE"
fi

echo ""
echo "ARCHIVED files (intentionally not touched):"
grep -rl "Irrig8" /home/workspace/Bxthre3 --include="*.md" 2>/dev/null | grep "ARCHIVED\|farmsense-code\|farmsense-portal" | wc -l
echo "  (These are legacy/archived and do not affect agent generation)"

echo ""
echo "Agent guardrails installed:"
for agent_file in "${AGENT_INSTRUCTIONS[@]}"; do
  if [ -f "$agent_file" ]; then
    if grep -q "Irrig8 is retired" "$agent_file" 2>/dev/null; then
      echo "  ✅ $(basename "$agent_file")"
    else
      echo "  ❌ $(basename "$agent_file") — guardrail missing"
    fi
  fi
done

echo ""
echo "=========================================="
echo "Completed: $(date -u)"
echo "Log saved to: $LOG"
echo "=========================================="
