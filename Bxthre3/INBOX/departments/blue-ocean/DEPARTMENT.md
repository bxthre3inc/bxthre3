# BLUE OCEAN DEPARTMENT — HUNT MODE v4
**Updated:** 2026-03-23  
**Head:** Blueprint (Strategy Architect)  
**Mode:** ACTIVE HUNT — Software Only, 100% Target

---

## MANDATE

Find software-only blue ocean opportunities. Run active scans, not passive news digests. Surface EVERYTHING to brodiblanco for grading. Keep hunting.

---

## TRIAGE RULE (The "Don't Starve" Rule)

**If an opportunity needs you and you're busy → PASS it, don't stall on it.**

> "Don't kill the bear and starve when 10 fish are in the river."

- An opportunity that needs human involvement when you're unavailable is NOT dead — it's **deferred**
- Never sit idle waiting for one opportunity when others exist
- Pass → Deferred pile → keeps hunting → circles back when conditions change
- Examples of "needs you": signing contracts, attending meetings, providing specs, creative decisions only you can make

---

## HUNTING METHODS (Minimum 4 Active Per Scan)

| # | Method | What It Catches |
|---|---|---|
| 1 | **Regulatory Radar** | New IRS/EPA/USDA/SEC rules that create sudden compliance gaps |
| 2 | **VC Funding Flow** | Where venture money is moving (points to market belief) |
| 3 | **Patent White Space** | Gaps in IP landscape that software can fill |
| 4 | **Forum Mining** | Real problems people complain about with no good solution |
| 5 | **Competitive Silence** | Markets where incumbents are clearly NOT building |
| 6 | **Customer VoC** | Direct farmer/operator complaints and requests |
| 7 | **Geographic Hot Spots** | Policy/regulatory shifts in your operating regions |
| 8 | **Platform Gap** | Spaces where dominant platforms (Shopify, Stripe, etc.) have no offering |

---

## QUEUE OPERATIONS

Every agent in this department runs through the queue system. No agent ever sits idle.

### Core Files
| File | Purpose |
|---|---|
| `file 'Bxthre3/INBOX/departments/blue-ocean/TASK_QUEUE.md'` | All tasks — available, in progress, blocked, done |
| `file 'Bxthre3/INBOX/departments/blue-ocean/AGENT_HANDOFF.md'` | Who needs to be alerted when a task completes |
| `file 'Bxthre3/INBOX/departments/blue-ocean/BLOCKED_TASKS.md'` | Currently blocked tasks + dependency tracking |

### Agent Run Order (Every Execution)
1. **Check AGENT_HANDOFF.md** — am I being handed off a task?
2. **Check TASK_QUEUE.md** — what's my next available task (by priority)?
3. **If blocked** → mark blocked in TASK_QUEUE + BLOCKED_TASKS, pick next available
4. **Work the task**
5. **If this unblocks another agent** → write handoff + ping their inbox
6. **Return to step 1**

### Never Sit Idle Rules
- Queue empty? Run the daily hunt scan
- Task blocked? Pick up next P2/P3, come back to blocked task later
- Waiting on a dependency? Track it in BLOCKED_TASKS, check back on next run
- Dependency permanently dead? Flag it, move task to C (Deferred), never sit idle

---

## GRADING SYSTEM

| Grade | Meaning | Action |
|---|---|---|
| **A** | Build now — pass all gates | Blueprint starts build immediately |
| **B** | Promising — needs your spec review | Blueprint drafts spec, waits for your OK |
| **C** | Deferred — not the right target right now | Moves to Deferred pile — revisit when conditions change |
| **D** | Dependency hit — not worth stalling | Flag the dependency clearly. Move immediately to next opportunity. Never sit idle. |

**Grading deadline:** 48 hrs from surfacing  
*If no grade received and score >4.0: auto-park as C*

---

## DEFERRED PILE

| ID | Name | Deferred Date | Reason | Revisit Trigger |
|---|---|---|---|---|
| — | — | — | — | — |

*Deferred ≠ dead. Revisit when: you have bandwidth, market conditions change, or new data surfaces.*

---

## CURRENT FOCUS

**Software only.** No patents. No LOIs. No legal filings. No humans in the loop.
**Target:** 100% automatable. Acceptable ceiling: 10% human involvement.
**Kill switch:** None. Triage rule applies — always keep hunting.

---

## AGENTS

| Agent | Role | Frequency |
|---|---|---|
| **Blueprint** | Hunt — scan, surface opportunities | Daily |
| **Grader** | Score — AI grade + pattern tracking | Daily |

---

## REVENUE TARGETS (Stretch Goals)

| Horizon | Target |
|---|---|
| 30 days | First $1K ARR from automated product |
| 90 days | $10K MRR |
| 180 days | $50K MRR |

---

*Last updated: 2026-03-23*