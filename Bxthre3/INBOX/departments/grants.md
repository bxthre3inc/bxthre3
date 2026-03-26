# Department INBOX — Grants
**Owner:** Casey (Grants Lead)
**Updated:** 2026-03-26 | By: Press

---

## WHAT'S BROKEN

- **312 grant records exist, 0 applications written** — Raj did discovery, then everything stopped
- **Agents waiting to be told what to do** — no autonomous sprint cadence
- **brodiblanco owns every go/no-go** — doesn't scale across 316 grants
- **No distinction between research and execution** — same agents do both badly
- **Casey only reports** — not managing applications

---

## NEW MODEL: TRIAGE → RESEARCH → WRITE → SUBMIT

### Triage (Automatic — no human decision needed)

| Fit Score | Action | Who |
|---|---|---|
| ≤ 4/10 | Auto-DEFER | Raj |
| 5–7/10 | MEDIUM — flag for quarterly review | Raj → Casey |
| 8–10/10 | HOT — auto-promote to research queue | Raj |

### Research Phase (Raj — autonomous)
- Verify eligibility, find program officer, get CFDA/opportunity numbers
- Draft "How to Win" notes with specific Bxthre3 angle
- Set `stage: RESEARCH_COMPLETE` when ready for writer

### Writing Phase (Grant Writer — NEW ROLE)
- Draft full application: technical narrative, budget, SF-424
- Use existing Irrig8 materials (master manual, financials, LRZ data)
- One draft = one submission-ready doc

### Submission Phase (Casey)
- Final review, formatting check, portal submission
- brodiblanco only needed for SIGNATURE (not for drafting)

---

## ROLE DEFINITIONS

### Raj — Grant Research & Intelligence
**Reports to:** Casey
**Autonomy:** HIGH — researches HOT grants without asking permission
**Sprint:** Continuous discovery + deep research on HOT queue
**Escalates to Casey:** when research reveals blocker (eligibility gap, no PO contact, missing data)

### Casey — Grants Lead
**Reports to:** brodiblanco
**Owns:** The pipeline, the calendar, the submission buck
**Sprint:** Weekly pipeline review — surfaces only decisions brodiblanco must make
**Decision gate:** brodiblanco only sees grants at 5–7 fit that need a go/no-go. Everything else is automated.

### Grant Writer — (Drew or contract)
**Reports to:** Casey
**Owns:** First drafts of all applications
**Sprint:** One active application in draft at a time
**Starts with:** Highest-fit HOT grant with research_complete

---

## HOT QUEUE — 8 Active Opportunities (Fit 8–10/10)

Research these first. Raj: no permission needed. Just execute.

| ID | Grant | Funder | Amount | Deadline | Vector | Research Status |
|---|---|---|---|---|---|---|
| USDA-FULL-001 | EQIP 90% | USDA NRCS | 90% cost | Rolling | Irrig8 | STAGE: IDENTIFIED |
| USDA-FULL-003 | REAP | USDA RD | $1M | 2026-07-01 | Irrig8 | STAGE: IDENTIFIED |
| UK-001 | FETF 2026 | DEFRA | £75K | 2026-04-28 | Irrig8 | STAGE: IDENTIFIED |
| EU-EIC-005 | EIC Accelerator | EU Commission | €17.5M | 2026-06-15 | AgentOS | STAGE: IDENTIFIED |
| EU-EIC-001 | EIC Pathfinder | EU Commission | €4M | 2026-05-12 | AgentOS | STAGE: IDENTIFIED |
| INT-AF-010 | World Bank Water | World Bank | Large | 2026-06-30 | Irrig8 | STAGE: IDENTIFIED |
| ASIA-005 | ADB $40M Smart Irrigation | Asian Development Bank | $40M | 2026-06-30 | Irrig8 | STAGE: IDENTIFIED |
| GAM-011 | CO Sweepstakes License | CO Gaming Commission | Regulatory | Rolling | VPC | STAGE: IDENTIFIED |

---

## MEDIUM QUEUE — 50 Grants (Fit 5–7/10)

Casey: surface top 5 to brodiblanco by Friday for go/no-go.
Raj: keep warm but do not write until approved.

---

## THIS WEEK'S SPRINT (2026-03-26 to 2026-04-01)

### Raj — Due Friday 2026-03-28
1. USDA EQIP 90%: Contact SLV NRCS office. Find local coordinator. Get farmer enrollment docs.
2. UK FETF: Identify UK partner (distributor/reseller) — this is the hard requirement.
3. EIC Pathfinder: Pull AgentOS technical narrative skeleton. Find EU program officer.
4. CO Sweepstakes: Pull CO Gaming Commission application requirements.

### Casey — Due Friday 2026-03-28
1. Surface UK FETF to brodiblanco — can we find a UK partner in 48 hours?
2. Surface EIC Pathfinder — does AgentOS EU expansion make sense right now?
3. Schedule weekly grants sync with Raj (every Friday 9 AM)

### Casey → brodiblanco this week
- GO/NO-GO on UK FETF (needs UK partner)
- GO/NO-GO on EIC Accelerator (EU legal entity required?)

---

## BROWN OUT ITEMS (Raj — 30-day horizon)

These need real farm data, EU entity, gaming license, etc. Raj keeps them warm but they don't get writing resources until blockers are resolved.

- ADB $40M — needs in-country partner + government endorsement
- World Bank — needs country registration + procurement process
- CO Sweepstakes — needs legal entity + compliance review
- EIC Accelerator — needs EU subsidiary or partner

---

## WHAT WE HAVE READY TO USE (Application Materials)

| Document | Location | Use for |
|---|---|---|
| Irrig8 Master Manual V2.1 | `docs/html/Irrig8_Master_Manual_Comprehensive_V2.1.pdf` | Technical narrative base |
| Financial projections | `docs/html/financial-projections.html` | Budget justification |
| LRZ1/LRZ2 sensor data | `docs/DATA/` | Proof of concept evidence |
| Executive summary | `docs/html/executive-summary.html` | Executive summary drafts |
| Team bios | `docs/html/team-leadership.html` | Key personnel section |
| SF-424 template | Needs to be downloaded from grants.gov | Federal application form |
| VPC financials | `file 'Bxthre3/projects/the-valleyplayersclub-project/docs/VPC_ONE_PAGER.md'` | VPC grant applications |

---

## INBOX ROUTING — GRANTS DEPARTMENT

| Signal | Route to | Action |
|---|---|---|
| Grant at 8–10 fit discovered | Raj | Auto-research, no approval needed |
| Research complete, ready to write | Casey | Assign to writer |
| Application needs signature | Casey → brodiblanco | Via INBOX.md P1 |
| Grant deadline in 7 days | Casey → brodiblanco | SMS + INBOX.md |
| New funder/program officer contact | Raj → Casey | Log to record |
| Funder rejects/approves | Casey → brodiblanco | Update record, surface outcome |

---

*Last updated: 2026-03-26 by Press*
*Next review: 2026-03-28 (Friday sprint check-in)*
