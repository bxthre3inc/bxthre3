# Vector — Motion Designer INBOX

## Hand-offs & Briefs

---

# IRRIG8 MOTION DESIGN BRIEF
**Prepared by:** Palette (Creative Director)  
**Date:** 2026-03-25  
**Status:** READY TO EXECUTE  
**Priority:** P1 — Blocking all production  

---

## 1. PRODUCT OVERVIEW

**Product Name:** Irrig8 (formerly FarmSense)  
**Tagline:** *Deterministic Farming Operating System*  
**Core Promise:** Know exactly where water is, where it's going, and stop it before it wastes a drop.

**System Architecture (5 Modules):**

| Module | Code | Name | Role | Key Visual |
|--------|------|------|------|------------|
| **VFA** | VFA | Vertical Field Anchor | Deep-truth soil probe. 4-depth profile (8"–48"). Ground calibration reference. | Probe sinking into soil, concentric rings radiating moisture data |
| **LRZB** | LRZB | Lateral Root Zone Beacon | Reference-grade lateral sensor. ±2% VWC + temperature. Calibration anchor for network. | 3D node with signal waves, temperature gradient overlay |
| **LRZN** | LRZN | Lateral Root Zone Node | High-density lateral nodes. ±3% VWC. Kriging interpolation workhorse. 12 per field. | Grid of small nodes, mesh network pulsing |
| **PMT** | PMT | Pivot Motion Tracker | Field hub. RTK GNSS (<5cm). Aggregates all sensors. Stall detection. Commands PFA. | Pivot arm with glowing trail path |
| **PFA** | PFA | Pressure & Flow Analyzer | Wellhead sentry. ±1% flow accuracy. Pump health via harmonic analysis. SIL 3 safety relay. | Flow pipe with data overlay, safety shield |

**System Flow:**
```
PFA (wellhead) → PMT (pivot) → DHU (district) → RSS (regional) → Cloud
      ↑              ↑
   [FLOW]        [VFA/LRZB/LRZN mesh]
```

---

## 2. BRAND IDENTITY

### Color Palette

| Role | Color | Hex | Usage |
|------|-------|-----|-------|
| **Primary** | Irrig8 Field Green | `#2D5016` | Dominant backgrounds, trust, agriculture |
| **Secondary** | Soil Earth | `#6B4423` | Grounding elements, depth |
| **Accent 1** | Water Blue | `#00A3E0` | Water flow, data streams, active states |
| **Accent 2** | Signal Amber | `#F59E0B` | Alerts, highlights, CTAs |
| **Danger** | Alert Red | `#DC2626` | Stall warnings, safety stops |
| **Background Dark** | Midnight | `#0F1419` | Video backgrounds, contrast |
| **Background Light** | Cloud White | `#F8FAFC` | Text on dark, clean surfaces |
| **Grid Lines** | Slate | `#64748B` | Data viz, technical overlays |

### Typography

| Role | Font | Weight | Usage |
|------|------|--------|-------|
| **Headlines** | Inter | 800 (ExtraBold) | Product names, module titles |
| **Subheads** | Inter | 600 (SemiBold) | Section titles |
| **Body** | Inter | 400 (Regular) | Descriptions, specs |
| **Technical/Data** | JetBrains Mono | 400 | Spec numbers, readings, code |

### Visual Tone

- **Primary Register:** Industrial-Agricultural Hybrid
  - Clean data visualization meets rugged field hardware
  - Think: John Deere precision ag crossed with aerospace telemetry
  
- **Motion Philosophy:**
  - **Water-like flow:** Bezier curves, fluid easing, ripple effects
  - **Data as landscape:** Topographic overlays, contour maps, heat fields
  - **Pulse rhythm:** Sensor chirp patterns, heartbeat timing (slower = dormant, faster = active)
  
- **Do NOT:** Over-tech it. Farmers are the audience. Keep warmth. Lead with the problem solved, not the technology.

---

## 3. TONE & VOICEOVER GUIDANCE

### Tone Spectrum

```
TECHNICAL ←──────────────────────────────────────────→ HUMAN
    │                                                    │
  Spec numbers                             Farmers solving
  Precision data                           real problems
  Engineer-speak                           Ground truth
```

**Target:** 70% Human / 30% Technical

### Key Emotional Beats

| Beat | Moment | Visual | Audio |
|------|--------|--------|-------|
| **Problem** | Water waste, over-irrigation, regulatory pressure | Dry field → data overlay | Ambient wind, tension |
| **Solution** | System sees the problem | Irrig8 mesh activating | Relief, confident tone |
| **Precision** | Every drop accounted for | Contour map filling | Data "clicking" into place |
| **Safety** | Stall detected, pump stops | Red alert → green safe | Urgent → calm |
| **Trust** | Water Court evidence package | Immutable ledger visualization | Resolution, closure |

---

## 4. MODULE STORY BOARDS

### 4.1 VFA — Vertical Field Anchor

**Story:** "The Deep Truth"

**Duration:** 20–25 sec

**Scene Sequence:**

| Time | Visual | Animation |
|------|--------|----------|
| 0–3s | Field aerial, center pivot dormant | Slow push-in, ambient grain |
| 3–6s | Cross-section of soil layers (8", 16", 24", 36", 48") | Labels fade in top-left, layer colors gradient darker with depth |
| 6–10s | VFA probe inserts vertically into soil cross-section | Probe descends with soft "thunk" — concentric sensor rings glow as they pass each depth |
| 10–14s | 4 data streams emerge (one per depth) — blue gradients | VWC readings cascade up in real-time: 12% → 18% → 24% → 31% → 8% |
| 14–18s | Data streams merge into a single "root signature" visualization | Topographic contour rings pulse outward from probe |
| 18–22s | VFA labeled: "48" Deep. Ground Truth." | Clean callout with green checkmark |
| 22–25s | VFA fades, PMT appears in corner as "aggregator" | Quick cut to final system mesh |

**Color Motif:** Soil Earth (#6B4423) → Water Blue (#00A3E0) gradient showing moisture penetration

**Lottie Spec:**
- Probe insertion: custom path animation
- Data streams: vertical bar chart with gradient fills
- Contour rings: expanding circle with opacity decay

---

### 4.2 LRZB — Lateral Root Zone Beacon

**Story:** "Reference Point"

**Duration:** 18–22 sec

**Scene Sequence:**

| Time | Visual | Animation |
|------|--------|----------|
| 0–4s | Pivot field from above (satellite view style) | Concentric rings appear: 25%, 50%, 75% radius |
| 4–8s | 4 LRZB nodes highlighted at cardinal points | Nodes pulse amber → confirm position |
| 8–12s | Cross-section cut showing LRZB + LRZN side-by-side | LRZB glows with temperature gradient (blue=cool, red=warm), LRZN stays neutral |
| 12–16s | LRZB broadcasts signal to PMT, quality score rises | Wave pulses from beacon, "±2% VWC" and "±0.5°C" appear |
| 16–20s | Comparison: LRZB accuracy vs uncompensated LRZN | Split screen: LRZB line flat/stable, LRZN line drifting with temp |
| 20–22s | Tagline: "The anchor that holds the grid true." | Clean lower-third callout |

**Color Motif:** Signal Amber (#F59E0B) for beacon activation, Water Blue for temperature data

**Lottie Spec:**
- Signal waves: 3 expanding arcs with stagger
- Temperature gradient: CSS gradient animation on node body
- Accuracy comparison: two line graphs animating simultaneously

---

### 4.3 LRZN — Lateral Root Zone Node

**Story:** "The Network"

**Duration:** 20–25 sec

**Scene Sequence:**

| Time | Visual | Animation |
|------|--------|----------|
| 0–4s | 16 dots appear on field grid (12 LRZN + 4 LRZB) | Dots pop in with stagger, 3 waves |
| 4–8s | PMT broadcasts "wake" signal | Ripple from pivot center, nodes light up sequentially |
| 8–12s | Each LRZN reads VWC, transmits via 900MHz LoRa | Small pulse from each node, data packets visualized |
| 12–16s | PMT aggregates all 16 readings → IDW interpolation | Grid fills in, color gradient shows moisture map |
| 16–20s | Zoom into one LRZN mid-chirp | Detail view: dielectric reading → VWC calculation |
| 20–24s | "50m grid. Every 4 hours. 4+ year battery." | Spec cards cascade in |

**Color Motif:** Field Green (#2D5016) base, Water Blue (#00A3E0) for active readings

**Lottie Spec:**
- Node activation: 16 circles with staggered opacity
- Data packets: small squares flying to PMT
- Grid fill: 4×4 cells with gradient interpolation animation

---

### 4.4 PMT — Pivot Motion Tracker

**Story:** "The Brain"

**Duration:** 25–30 sec

**Scene Sequence:**

| Time | Visual | Animation |
|------|--------|----------|
| 0–4s | Pivot irrigation system in motion | Slow pan following the arm |
| 4–8s | PMT enclosure mounted on last span | Zoom to detail, LEDs blinking green |
| 8–12s | RTK GNSS accuracy visualization | Path trail draws with ±5cm confidence band |
| 12–16s | IMU stall detection trigger | Pivot slows → red warning flash → instant stop |
| 16–20s | PMT sends ACTUATE_STOP to PFA | Command packet flies from PMT to PFA icon |
| 20–25s | 187-byte field state payload breakdown | Data blocks stack: GNSS + IMU + sensors + grid stats |
| 25–30s | "850ms. From detection to pump stop." | Large callout, safety shield icon |

**Color Motif:** Midnight (#0F1419) background, Signal Amber for alerts, Danger Red (#DC2626) for stall, Field Green for safe

**Lottie Spec:**
- Pivot path: curved line with gradient stroke
- Stall sequence: red flash → stop icon → safe green
- Data payload: stacked horizontal bars animating in sequence

---

### 4.5 PFA — Pressure & Flow Analyzer

**Story:** "The Guardian"

**Duration:** 25–30 sec

**Scene Sequence:**

| Time | Visual | Animation |
|------|--------|----------|
| 0–4s | Wellhead from ground level | Push in on pipe, water flow visible |
| 4–8s | PFA enclosure mounted, flow meter clamps on | Clamp-on sensors attach with satisfying click |
| 8–12s | Ultrasonic flow visualization | Two wave lines (upstream/downstream) with Δt highlighted |
| 12–16s | Pump health analysis | 3-phase current waveform → FFT bars rising |
| 16–20s | Reflex logic table appears | Conditions list with pass/fail indicators |
| 20–25s | Safety relay triggers | Contact closes, pump icon stops, green "SAFE" |
| 25–30s | Compliance evidence package | Files assembling: flow_data.csv, cert, hash chain |

**Color Motif:** Water Blue (#00A3E0) for flow, Alert Red for safety triggers, Cloud White for safe state

**Lottie Spec:**
- Ultrasonic waves: two parallel lines with differential highlight
- FFT bars: rising histogram with harmonic labels (2nd, 3rd, 5th, HF)
- Safety relay: mechanical contact animation with spark

---

## 5. DELIVERABLE SPECIFICATIONS

### Video Deliverables

| Asset | Format | Duration | Resolution | FPS | Codec |
|-------|--------|----------|------------|-----|-------|
| **Master Explainer** | MP4 (H.264) | 90–120 sec | 1920×1080 | 30 | High profile |
| **Social Cut (Instagram/TikTok)** | MP4 (H.264) | 15–30 sec | 1080×1920 (9:16) | 30 | High profile |
| **Trade Show Loop** | MP4 (H.264) | 30 sec | 3840×2160 (4K) | 60 | High profile |
| **Investor Deck Insert** | MOV (ProRes 422) | 8–12 sec each | 1920×1080 | 30 | ProRes |

### Lottie Deliverables

| Asset | File | Dimensions | Frames | Purpose |
|-------|------|------------|--------|---------|
| VFA Probe Insert | `vfa_probe_insert.json` | 400×600 | 120 | Product page hero |
| LRZB Signal Wave | `lrzb_signal_wave.json` | 200×200 | 60 | Module icon |
| LRZN Mesh Grid | `lrzn_mesh_grid.json` | 400×400 | 90 | Dashboard widget |
| PMT Stall Alert | `pmt_stall_alert.json` | 300×300 | 45 | Alert state |
| PFA Flow Gauge | `pfa_flow_gauge.json` | 300×300 | 120 | Real-time display |
| System Status Ring | `system_status_ring.json` | 400×400 | Loop | Overall health |

### Animation Standards

- **Easing:** Custom bezier curves. No linear. Water-inspired: `cubic-bezier(0.4, 0, 0.2, 1)` default
- **Data animations:** Stagger 50ms between elements
- **Loop points:** All Lottie files must loop seamlessly
- **Color mode:** sRGB (not Display P3) for compatibility
- **File size:** Lottie < 200KB each

---

## 6. PRODUCTION NOTES

### Module Execution Order (Priority)

1. **PMT** — Most visually dramatic (stall detection = instant engagement)
2. **VFA** — Technical credibility (deep truth = engineering confidence)
3. **PFA** — Safety story (regulatory + emotional trust)
4. **LRZB** — Validation story (why precision matters)
5. **LRZN** — Density story (the network effect)

### Reference Materials

All specs are in: `Bxthre3/projects/the-irrig8-project/docs/specs/`
- `PMT-SPEC.md` — V1.7
- `VFA-SPEC.md` — V2.1
- `LRZB-SPEC.md` — V1.2
- `LRZN-SPEC.md` — V1.2
- `PFA-SPEC.md` — V1.9

### Asset Storage

Final deliverables: `Bxthre3/projects/the-irrig8-project/design/motion/`
Filename convention: `{MODULE}_{ASSET-TYPE}_{VERSION}.{ext}`
Example: `PMT_stall_alert_v1.mp4`, `vfa_probe_insert.json`

---

## 7. APPROVAL SIGNATURES

| Role | Agent | Status | Date |
|------|-------|--------|------|
| Creative Director | Palette | ✅ Approved | 2026-03-25 |
| Motion Designer | Vector | ⏳ Pending Execution | — |

---

## PRODUCTION STATUS

### 2026-03-25 | Brief Received — EXECUTING

**Brief Source:** Palette INBOX.md P1 request
**Status:** ✅ Brief confirmed complete and actionable

**Execution Plan:**
1. ⏳ **PMT** — Starting first (stall detection = highest drama)
2. 🔲 **VFA** — Next (technical credibility)
3. 🔲 **PFA** — Third (safety + regulatory trust)
4. 🔲 **LRZB** — Fourth (precision validation)
5. 🔲 **LRZN** — Last (network density)

**Tools Available:** After Effects, Premiere Pro, DaVinci Resolve, Lottie
**Storage:** `Bxthre3/projects/the-irrig8-project/design/motion/`

---

*Brief prepared per Palette's P1 request. All creative direction is go. Execute immediately.*
