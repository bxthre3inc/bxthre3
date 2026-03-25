# BLUE OCEAN — TASK QUEUE
**Head:** Blueprint (Strategy Architect)  
**Last Updated:** 2026-03-23

---

## QUEUE STATUS AT A GLANCE

| Queue Depth | In Progress | Blocked | Done Today |
|---|---|---|---|
| 0 | 0 | 0 | 0 |

---

## TASK ROSTER

| Task ID | Task | Agent | Status | Blocked By | Priority | Created | Updated | Notes |
|---|---|---|---|---|---|---|---|---|
| — | — | — | — | — | — | — | — | — |

---

## HOW THE QUEUE WORKS

### Status States
| Status | Meaning | Agent Action |
|---|---|---|
| `available` | Ready to work | Agent picks it up immediately |
| `in_progress` | Being worked | Agent is on it |
| `blocked` | Waiting on dependency | Agent checks back periodically |
| `done` | Complete | Move to done log |

### Dependency Resolution
When a task is marked `done`:
1. Scan all `blocked` tasks
2. If their `Blocked By` = completed task ID → mark `available`, alert assigned agent
3. Agent picks up next highest priority `available` task

### Priority
- P1 = Urgent (do now)
- P2 = High (do next)
- P3 = Normal (queue order)

---

## DONE LOG

| Task ID | Task | Completed | Duration |
|---|---|---|---|
| — | — | — | — |

---

## AGENT AUTONOMY RULES

1. **Always have a task.** If queue is empty, run the daily scan hunt
2. **Never sit idle.** If blocked, pick up next available P2/P3 task
3. **Check dependencies every 30 minutes.** When blocked task becomes available, move it to top
4. **Alert downstream agents.** When you complete a task that unblocks another agent, ping them
5. **Chain handoff.** When Task A done → Task B is now available → immediately begin Task B

---

*Queue updated by whichever agent acts on it. Last write wins — coordinate via timestamp.*
