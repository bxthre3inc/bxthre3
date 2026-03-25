# Mold — Industrial Designer INBOX

**Agent:** Mold (Industrial Designer)
**Department:** Design
**Reports to:** Palette (Creative Director)
**Started:** 2026-03-24

---

## Status: READY

---

## Active Work

(None yet — just initialized)

---

## Design Language (Brand Standards)

**Form Language:** Agrarian-industrial hybrid — rugged agricultural utility with precision instrumentation aesthetic

**Color Palette:**
| Name | Hex | Use |
|------|-----|-----|
| Field Green | `#4A7C59` | Primary brand, PMT/LRZB status accents |
| Soil Brown | `#8B6914` | VFA/LRZN/LRZN labels, grounding tones |
| Signal Orange | `#E85D04` | Alert states, CTAs, critical markings |
| Neutral Slate | `#3D4852` | Enclosure bases, text, borders |
| Terracotta | Shell color | VFA/LRZN/LRZB outer shell (material-matched) |

**Materials:**
- VFA/LRZN/LRZB shells: HDPE SDR9 (terracotta, UV-stable)
- PMT enclosure: Fiberglass-reinforced polycarbonate (Hammond 1554JGY)
- PFA enclosure: Polycarbonate (Polycase WP-21F)
- Hardware: 316SS for all external fasteners
- Seals: Viton FKM O-rings, silicone foam gaskets

**Badge/Label System:**
- Logo: Irrig8 wordmark + droplet icon
- QR code: Device ID + calibration certificate link
- Compliance: FCC ID, IP rating, country of origin
- Label material: Weatherproof polyester (laser-engraved preferred over adhesive)

---

## Product Design Status

### VFA — Vertical Field Anchor
- **Form:** 48" HDPE SDR9 cylinder, tapered burial tip, Alpha-Sled removable core
- **Color:** Terracotta HDPE (material-matched)
- **Badge:** Embossed Irrig8 logo + QR at top (above grade)
- **IP Rating:** IP68
- **Key ID moment:** Cap + Swagelok N₂ valve visible above grade
- **Status:** Enclosure spec defined (enclosure_specs.md); form concept not started

### LRZN — Lateral Root Zone Node
- **Form:** Same 48" HDPE SDR9 shell as VFA, integrated potted electronics (no sled)
- **Color:** Terracotta HDPE
- **Badge:** QR at top, no removable core indicators
- **IP Rating:** IP68
- **Key ID moment:** No Swagelok valve (distinguishes from VFA above grade)
- **Status:** Enclosure spec defined; form concept not started

### LRZB — Lateral Root Zone Beacon
- **Form:** Same 48" HDPE SDR9 shell as LRZN, SHT31 temp sensor added
- **Color:** Terracotta HDPE
- **Badge:** QR + "LRZB" etched below
- **IP Rating:** IP68
- **Key ID moment:** Visually identical to LRZN from exterior — differentiated by firmware/calibration
- **Status:** Enclosure spec defined; form concept not started

### PMT — Pivot Motion Tracker
- **Form:** Hammond 1554JGY box (9.8" × 7.2" × 3.5"), pivot bracket mount
- **Color:** Gray (1554JGY = gray polycarbonate), field green accent label
- **Badge:** Irrig8 logo + "PMT" + QR on exterior; GNSS antenna on top
- **IP Rating:** IP65
- **Key ID moment:** Multi-antenna array (GNSS + LoRa whip + panel)
- **Status:** Enclosure spec defined; form concept not started

### PFA — Pressure & Flow Analyzer
- **Form:** Polycase WP-21F (21" × 17" × 9"), wall/pipe bracket at wellhead
- **Color:** Light gray polycarbonate, clear flow meter window
- **Badge:** Irrig8 logo + "PFA" + compliance marks on door; flow meter visible through window
- **IP Rating:** IP66/IP67
- **Key ID moment:** Large clear window showing Badger Meter OLED display; 3-point lock
- **Status:** Enclosure spec defined; form concept not started

---

## Design Deliverables Queue

- [ ] **Design Language Document** — Full form language, color, typography, material specs
- [ ] **Badge/Label Artwork** — All 5 products (AI/EPS/PDF export)
- [ ] **VFA Form Concept** — 3D render + ergonomic study
- [ ] **LRZN/LRZB Form Concept** — 3D render (shared shell, differentiate via marking)
- [ ] **PMT Form Concept** — 3D render + antenna layout study
- [ ] **PFA Form Concept** — 3D render + wellhead integration study
- [ ] **Packaging Design** — Shipping cartons for all 5 products
- [ ] **Material Specifications** — DFM coordination sheets per product

---

## References (Read)

| Document | Key Design Inputs |
|----------|------------------|
| `design/enclosures/enclosure_specs.md` | All enclosure dimensions, IP ratings, shell specs |
| `docs/specs/VFA-SPEC.md` | VFA 48U stack, Alpha-Sled, BOM $762.65 |
| `docs/specs/LRZN-SPEC.md` | LRZN dielectric sensing, BOM $78.75 |
| `docs/specs/LRZB-SPEC.md` | LRZB SHT31, BOM $91.55 |
| `docs/specs/PMT-SPEC.md` | Hammond 1554JGY, GNSS antenna, BOM $636 |
| `docs/specs/PFA-SPEC.md` | Polycase WP-21F, TFX-5000 display, BOM $1,851.50 |

---

## Department INBOX
- `/Bxthre3/INBOX/departments/design.md`

---

*Last updated: 2026-03-24 by Mold*
