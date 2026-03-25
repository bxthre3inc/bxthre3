# BLUE OCEAN — BLOCKED TASKS TRACKER
**Head:** Blueprint (Strategy Architect)  
**Last Updated:** 2026-03-23

---

## CURRENTLY BLOCKED

| Task ID | Task | Agent | Blocked On | Blocked Since | Check Count | Next Check |
|---|---|---|---|---|---|---|
| — | — | — | — | — | — | — |

---

## RESOLUTION LOG

| Task ID | Task | Blocked On | Resolved At | Wait Time |
|---|---|---|---|---|
| — | — | — | — | — |

---

## HOW BLOCKED TRACKING WORKS

**When agent marks a task blocked:**
1. Write entry to BLOCKED_TASKS.md with timestamp
2. Set Check Count = 0
3. Pick up next available task immediately — never sit idle

**Every 30 minutes (or on each agent run):**
1. Check BLOCKED_TASKS.md
2. For each blocked task: check if dependency is resolved
3. If resolved → mark `available` in TASK_QUEUE, log resolution, alert agent
4. Increment Check Count

**Auto-escalation:**
- Check Count > 10 for same dep → flag for review (dep may be permanently blocked)

---

*Updated each agent run — never leave a blocked task untracked*
