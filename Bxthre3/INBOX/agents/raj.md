# Raj — Agent INBOX

## IMMEDIATE PRIORITY — ESTCP Phase II (IRR-001)
**Deadline: March 26, 2026 — 3 days away**
- Stage: WRITING (per Casey)
- Status: Field validation complete, ready for submission
- Blocker: FarmSense backend service not registered
- Action: If Drew unblocks backend today — prepare final submission package. If not — escalate to Jeremy for placeholder data approval.

---

## PRIORITY 1 — 316 Grant Records to Build
**Assigned: 2026-03-23 | Due: Ongoing**

Today, 316 grants were documented across 15 batch files. Each needs to be promoted from a 2-line entry into a full 12-section record.

**Data spec:** `Bxthre3/grants/GRANT_RECORD_SPEC.md`

**Batches to process (in order):**
1. `Bxthre3/grants/BATCH-01-FED-US.md` — 20 US Federal grants
2. `Bxthre3/grants/BATCH-02-FED-US.md` — 22 US Federal EPA grants
3. `Bxthre3/grants/BATCH-03-FED-US.md` — 22 US Federal DoD/DARPA grants
4. `Bxthre3/grants/BATCH-04-STATE-CO.md` — 21 Colorado state grants
5. `Bxthre3/grants/BATCH-05-INTL-EU.md` — 20 EU/UK grants
6. `Bxthre3/grants/BATCH-06-CA-FOUND.md` — 21 Canada + Foundations
7. `Bxthre3/grants/BATCH-07-FED-US-2.md` — 20 US Federal round 2
8. `Bxthre3/grants/BATCH-08-FED-US-3.md` — 20 US Federal round 3
9. `Bxthre3/grants/BATCH-09-STATE-ALL.md` — 20 State grants
10. `Bxthre3/grants/BATCH-10-INTL-ALL.md` — 20 International
11. `Bxthre3/grants/BATCH-11-FED-US-4.md` — 20 US Federal round 4
12. `Bxthre3/grants/BATCH-12-EU-GLOBAL.md` — 20 EU/Global
13. `Bxthre3/grants/BATCH-13-EU-FOUND.md` — 20 EU/Foundations
14. `Bxthre3/grants/BATCH-14-FED-US-5.md` — 20 US Federal round 5
15. `Bxthre3/grants/BATCH-15-REALESTATE.md` — 20 Real Estate/Gaming/Fintech

**Process for each batch:**
1. Open batch file
2. For each grant, create a file: `Bxthre3/grants/records/{GRANT_ID}.md`
3. Fill in Sections 1-4 (ID, Financial, Timeline, Eligibility) from batch data
4. Flag for Casey/Grant Intelligence to fill Sections 5-12 (requirements, fit, strategy)
5. Update PIPELINE_INDEX.md with new record count

**Output:** One `.md` file per grant using the 12-section spec

---

## PRIORITY 2 — Daily Pipeline Report
Every morning, generate a grants pipeline report and post to:
- `Bxthre3/INBOX/departments/grants.md`
- `Bxthre3/INBOX/agents/casey.md` (cc)

**Report format:**
- Grants by stage (IDENTIFIED / RESEARCHING / DRAFTING / REVIEWING / SUBMITTED / AWARDED)
- Deadlines within 14 days — flag any
- New grants assigned this cycle
- Blockers — escalate to INBOX.md if P0/P1

---

## Daily Reports

### 2026-03-23
**Status:** Starting grant record build — 316 grants across 15 batches
**First action:** Process BATCH-01-FED-US.md
**ESTCP status:** Monitoring — 3 days to deadline

---

## Hand-offs

---

## Blockers
- Need Casey/Grant Intelligence to complete Sections 5-12 once Sections 1-4 are drafted

---

## Notes
- Working in `Bxthre3/grants/` directory
- Spec file: `GRANT_RECORD_SPEC.md`
- Batch files: `BATCH-XX-*.md`
- Output directory: `Bxthre3/grants/records/`
- Pipeline index: `Bxthre3/grants/PIPELINE_INDEX.md`

---
*Last updated: 2026-03-23*
