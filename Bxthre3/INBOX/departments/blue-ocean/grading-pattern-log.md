# BLUE OCEAN — GRADING PATTERN LOG
**Purpose:** Track divergence between AI grades and human grades to calibrate scoring criteria

---

## PATTERN LOG

### 2026-03-23 — First Cycle

| Opportunity | AI Score | AI Grade | Human Score | Human Grade | Delta | Pattern Note |
|---|---|---|---|---|---|---|
| O-001: Arid-Land Ethanol CI | 2.75 | D | ___ | ___ | — | First cycle — no human grade yet |
| O-002: Starting5 Self-Serve | 3.35 | C | ___ | ___ | — | First cycle — no human grade yet |
| O-003: Water Court Evidence Auto | 4.05 | B | ___ | ___ | — | First cycle — no human grade yet |

### 2026-03-25 — Second Cycle

| Opportunity | AI Score | AI Grade | Blueprint Score | Blueprint Grade | Delta | Pattern Note |
|---|---|---|---|---|---|---|
| O-001: Ag Data Bridge (USDA) | 3.55 | C | 3.90 | B | -0.35 | Divergence on Time to Cash: AI scores 2, Blueprint scores 2.5 — AI treats USDA API dependency as a hard blocker; Blueprint treats it as manageable |
| O-002: Colorado River Water Rights | 4.45 | A | 4.475 | A | -0.025 | Near-perfect alignment. Both recognize geographic moat + regulatory tailwind |
| O-003: Ag Chemical Input Compliance | 3.15 | C | 3.075 | C | +0.075 | Minor divergence — near-identical scores. EPA rulemaking timeline is the key risk |
| O-004: Farm Equipment Right-to-Repair | 2.55 | D | 3.275 | C | -0.725 | **Largest divergence.** AI kills; Blueprint defers. Key disagreement: OEM pushback as structural vs. regulatory risk |
| O-005: Autonomous Irrigation Engine | 4.55 | A | 4.525 | A | +0.025 | Near-perfect alignment. Both identify this as core Irrig8 vision |
| O-006: Ag Contractor Logistics | 3.15 | C | 3.65 | B | -0.50 | AI parks; Blueprint flags promising. Key disagreement: Bxthre3 fit (AI: 2, Blueprint: 3) and defensibility |

**Cycle 2 Calibration Notes:**
- Blueprint consistently scores Bxthre3 Fit 0.5-1.0 points higher than AI when the opportunity is adjacent to agriculture but not core irrigation/water
- AI is more aggressive on "kill" for poor-fit opportunities (O-4: AI=D, Blueprint=C)
- Both agree on A-grade opportunities (O-2, O-5) with <0.03 delta
- Time to Cash is the most subjective criterion — AI tends to be more conservative when government/regulatory dependencies exist
- O-1 and O-6 show pattern: Blueprint gives partial credit for "speculative build" while AI waits for confirmed API availability

---

## CALIBRATION NOTES

**Observations from first cycle:**
- AI weighted scoring treats automation level as 25% weight — human may weight uniqueness or speed differently
- O-003 scored 4.05/5.0 (barely B) — human may agree or want stricter automation threshold
- O-001 scored low primarily on automation and fit — human may disagree if they value uniqueness more
- Triage rule noted: opportunity that needs human mid-build when you're unavailable = grade C (Deferred)

**Scoring calibration after 5+ cycles:**
- If AI consistently grades higher than human → increase automation weight or lower uniqueness weight
- If AI consistently grades lower than human → decrease automation weight or increase uniqueness weight
- Watch for bias: AI may over-weight "clean data" (sources) vs. "market feel"
- Watch for triage divergence: AI may defer too aggressively or not aggressively enough

---

## DEFERRED PILE LOG

| ID | Opportunity | Deferred Date | Reason | Revisit Trigger | Status |
|---|---|---|---|---|---|
| O-001 | Ag Data Bridge (USDA "One Farmer, One File" Integrator) | 2026-03-25 | Time to Cash: USDA API not live until ~2028; building on unstable spec | USDA API publication or 2026-06-25 (90 days) | Parked |
| O-003 | Ag Chemical Input Compliance Tracker (EPA ESA/Dicamba) | 2026-03-25 | EPA rulemaking timeline uncertain; final rule not yet published | EPA final rule signal from RAIN agent or 2026-05-25 (60 days) | Parked |
| O-004 | Farm Equipment Right-to-Repair Middleware | 2026-03-25 | Kill — OEM pushback is structural barrier, not regulatory risk; poor Bxthre3 fit | Never (D grade — below threshold) | **Killed** |
| O-006 | Agricultural Contractor Logistics Orchestration Platform | 2026-03-25 | Low Bxthre3 fit (logistics not water); Ever.Ag incumbent risk | Ever.Ag stumbles or brodiblanco explores non-irrigation verticals; 2026-05-25 | Parked |

---

*Pattern log updated by Grader agent after each scan cycle*
