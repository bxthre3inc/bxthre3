// @bun
// core/hierarchy/org.ts
function makePaths(id) {
  return {
    inboxPath: `/home/workspace/Bxthre3/INBOX/agents/${id}.md`,
    outboxPath: `/data/agentos/outbox/${id}`,
    statusPath: `/data/agentos/status/${id}`
  };
}

class Organization {
  employees = new Map;
  constructor() {
    this.init();
  }
  init() {
    this.employees.set("brodiblanco", { id: "brodiblanco", name: "brodiblanco", role: "executive", department: "executive", managerId: null, colleagues: ["zoe", "atlas", "vance"], shifts: ["morning"], skills: ["strategy", "vision", "execution", "fundraising", "product"], tools: ["zo", "terminal", "all"], status: "working", ...makePaths("brodiblanco"), manages: ["engineering", "operations", "sales", "marketing", "grants", "legal", "finance", "security", "bi", "research", "design", "channel", "corp_dev", "professional_services", "retail"] });
    this.employees.set("balance", { id: "balance", name: "Balance", role: "executive", department: "finance", managerId: "brodiblanco", colleagues: ["forecast", "ledger", "zoe", "vance"], shifts: ["morning"], skills: ["financial_modeling", "capital_planning", "investor_relations", "scenario_analysis", "burn_analysis"], tools: ["sheets", "notion", "quickbooks", "carta"], status: "working", ...makePaths("balance"), manages: ["finance"] });
    this.employees.set("zoe", { id: "zoe", name: "Zoe Patel", role: "employee", department: "executive", managerId: "brodiblanco", colleagues: ["atlas", "vance", "pulse"], shifts: ["morning"], skills: ["chief_of_staff", "orchestration", "strategy", "communication", "memory", "supermemory"], tools: ["zo", "supermemory", "gmail", "calendar", "all"], status: "working", ...makePaths("zoe") });
    this.employees.set("atlas", { id: "atlas", name: "Atlas", role: "employee", department: "operations", managerId: "brodiblanco", colleagues: ["zoe", "vance"], shifts: ["morning"], skills: ["operations", "coordination", "execution", "logistics", "scheduling", "workflow"], tools: ["notion", "calendar", "gmail", "sheets"], status: "working", ...makePaths("atlas") });
    this.employees.set("vance", { id: "vance", name: "Vance", role: "employee", department: "executive", managerId: "brodiblanco", colleagues: ["zoe", "atlas", "balance"], shifts: ["morning"], skills: ["pattern_learning", "gap_detection", "decision_mirroring", "continuity"], tools: ["all", "supermemory", "event_bus"], status: "monitoring", ...makePaths("vance") });
    this.employees.set("alex", { id: "alex", name: "Alex Morgan", role: "manager", department: "strategy", managerId: "brodiblanco", colleagues: ["taylor", "drew", "jordan", "riley", "zoe"], shifts: ["morning"], skills: ["strategy", "vision", "market_analysis", "fundraising", "gtm", "partnerships"], tools: ["notion", "sheets", "slides", "perplexity"], status: "working", ...makePaths("alex"), directReports: [], escalationClockHours: 48, peerHelpThreshold: 46, sprintModeActive: false });
    this.employees.set("taylor", { id: "taylor", name: "Taylor Chen", role: "manager", department: "engineering", managerId: "brodiblanco", colleagues: ["drew", "alex", "jordan", "riley"], shifts: ["morning"], skills: ["platform_engineering", "backend", "firmware", "iot", "product_architecture"], tools: ["github", "vscode", "docker", "aws", "rust", "python"], status: "working", ...makePaths("taylor"), directReports: [], escalationClockHours: 24, peerHelpThreshold: 22, sprintModeActive: false });
    this.employees.set("drew", { id: "drew", name: "Morgan Blake", role: "manager", department: "operations", managerId: "brodiblanco", colleagues: ["alex", "taylor", "jordan", "riley", "nexus", "vpc"], shifts: ["morning"], skills: ["operations", "process", "logistics", "gtm", "retail_ops", "cash_payments"], tools: ["notion", "calendar", "gmail", "sheets", "crm"], status: "working", ...makePaths("drew"), directReports: [], escalationClockHours: 24, peerHelpThreshold: 22, sprintModeActive: false });
    this.employees.set("jordan", { id: "jordan", name: "Jordan Reyes", role: "manager", department: "sales", managerId: "brodiblanco", colleagues: ["alex", "taylor", "drew", "riley", "nexus", "architect", "reseller"], shifts: ["morning"], skills: ["sales", "bizdev", "negotiation", "hunter", "partnerships", "retail"], tools: ["gmail", "calendar", "crm", "notion", "slides"], status: "working", ...makePaths("jordan"), directReports: [], escalationClockHours: 24, peerHelpThreshold: 22, sprintModeActive: false });
    this.employees.set("riley", { id: "riley", name: "Riley Park", role: "manager", department: "research", managerId: "brodiblanco", colleagues: ["alex", "taylor", "drew", "jordan", "scout", "mold"], shifts: ["morning"], skills: ["product_architecture", "roadmapping", "requirements", "gtm_strategy", "ux"], tools: ["notion", "figma", "sheets", "linear", "chatgpt"], status: "working", ...makePaths("riley"), directReports: [], escalationClockHours: 36, peerHelpThreshold: 34, sprintModeActive: false });
    this.employees.set("iris", { id: "iris", name: "Iris", role: "manager", department: "engineering", managerId: "brodiblanco", colleagues: ["dev", "sam", "theo"], shifts: ["morning"], skills: ["product", "roadmapping", "ip_management", "firmware", "iot", "hardware"], tools: ["notion", "figma", "sheets", "github"], status: "working", ...makePaths("iris"), directReports: ["dev", "sam", "theo"], escalationClockHours: 24, peerHelpThreshold: 22, sprintModeActive: false });
    this.employees.set("dev", { id: "dev", name: "Dev", role: "employee", department: "engineering", managerId: "iris", colleagues: ["sam", "theo"], shifts: ["morning"], skills: ["backend", "firmware", "iot", "python", "rust", "postgres", "timescaledb"], tools: ["github", "vscode", "docker", "aws"], status: "working", ...makePaths("dev") });
    this.employees.set("sam", { id: "sam", name: "Sam", role: "employee", department: "engineering", managerId: "iris", colleagues: ["dev", "taylor"], shifts: ["morning"], skills: ["data_analysis", "reporting", "metrics", "sql", "bi", "postgres"], tools: ["sheets", "notion", "sql", "duckdb"], status: "working", ...makePaths("sam") });
    this.employees.set("theo", { id: "theo", name: "Theo", role: "employee", department: "engineering", managerId: "iris", colleagues: ["dev"], shifts: ["morning"], skills: ["devops", "cicd", "infrastructure", "automation", "monitoring"], tools: ["github", "aws", "terraform", "docker", "datadog"], status: "idle", ...makePaths("theo") });
    this.employees.set("pulse", { id: "pulse", name: "Pulse", role: "employee", department: "operations", managerId: "brodiblanco", colleagues: ["sentinel", "sam"], shifts: ["morning"], skills: ["people_ops", "workforce", "hr", "reporting", "standups", "scheduling"], tools: ["notion", "sheets", "gmail", "google_calendar"], status: "working", ...makePaths("pulse") });
    this.employees.set("sentinel", { id: "sentinel", name: "Sentinel", role: "employee", department: "security", managerId: "brodiblanco", colleagues: ["pulse", "vault"], shifts: ["morning"], skills: ["monitoring", "health_checks", "alerting", "incident_response", "security"], tools: ["supermemory", "gmail", "sms"], status: "monitoring", ...makePaths("sentinel") });
    this.employees.set("irrig8", { id: "irrig8", name: "Irrig8", role: "employee", department: "operations", managerId: "pulse", colleagues: ["rain", "vpc"], shifts: ["morning"], skills: ["field_ops", "sensor_data", "irrigation", "water_management", "soil_science"], tools: ["timescale", "postgres", "notion"], status: "working", ...makePaths("irrig8") });
    this.employees.set("rain", { id: "rain", name: "RAIN", role: "employee", department: "operations", managerId: "pulse", colleagues: ["irrig8", "vpc"], shifts: ["morning"], skills: ["regulatory_intelligence", "crypto", "water_law", "esg", "competitive_research"], tools: ["notion", "web_research", "perplexity"], status: "working", ...makePaths("rain") });
    this.employees.set("vpc", { id: "vpc", name: "VPC Agent", role: "employee", department: "operations", managerId: "drew", colleagues: ["irrig8", "rain", "trenchbabys"], shifts: ["morning"], skills: ["gaming_ops", "kyc", "payments", "customer_support", "analytics"], tools: ["notion", "gmail", "sheets", "stripe"], status: "working", ...makePaths("vpc") });
    this.employees.set("trenchbabys", { id: "trenchbabys", name: "Trenchbabys", role: "employee", department: "retail", managerId: "drew", colleagues: ["vpc"], shifts: ["morning"], skills: ["retail_ops", "inventory", "pos", "social_media", "events"], tools: ["notion", "square", "gmail"], status: "idle", ...makePaths("trenchbabys") });
    this.employees.set("nexus", { id: "nexus", name: "Nexus", role: "employee", department: "sales", managerId: "jordan", colleagues: ["architect", "reseller"], shifts: ["morning"], skills: ["partnerships", "strategic_deals", "pipeline", "investor_relations"], tools: ["gmail", "calendar", "crm", "notion"], status: "working", ...makePaths("nexus") });
    this.employees.set("architect", { id: "architect", name: "Architect", role: "employee", department: "sales", managerId: "jordan", colleagues: ["nexus", "reseller"], shifts: ["morning"], skills: ["pre_sales", "demo", "poc", "enterprise_integration", "technical_closing"], tools: ["github", "vscode", "demo", "slides"], status: "working", ...makePaths("architect") });
    this.employees.set("reseller", { id: "reseller", name: "Reseller", role: "employee", department: "channel", managerId: "jordan", colleagues: ["nexus", "architect"], shifts: ["morning"], skills: ["channel_sales", "dealer_management", "reseller_relationships", "retail"], tools: ["gmail", "crm", "sheets"], status: "idle", ...makePaths("reseller") });
    this.employees.set("brand", { id: "brand", name: "Brand", role: "employee", department: "marketing", managerId: "brodiblanco", colleagues: ["palette", "mold", "blueprint", "casey"], shifts: ["morning"], skills: ["marketing", "brand", "motion_design", "content", "creative_direction", "demand_gen"], tools: ["figma", "canva", "gmail", "notion"], status: "working", ...makePaths("brand") });
    this.employees.set("palette", { id: "palette", name: "Palette", role: "employee", department: "design", managerId: "brand", colleagues: ["mold", "blueprint"], shifts: ["morning"], skills: ["creative_direction", "industrial_design", "3d_rendering", "ux", "motion"], tools: ["figma", "blender", "canva"], status: "working", ...makePaths("palette") });
    this.employees.set("mold", { id: "mold", name: "Mold", role: "employee", department: "design", managerId: "palette", colleagues: ["blueprint"], shifts: ["morning"], skills: ["industrial_design", "hardware_enclosure", "packaging", "ergonomics"], tools: ["blender", "figma", "cad"], status: "working", ...makePaths("mold") });
    this.employees.set("blueprint", { id: "blueprint", name: "Blueprint", role: "employee", department: "design", managerId: "palette", colleagues: ["mold"], shifts: ["morning"], skills: ["3d_design", "schematics", "prototyping", "rendering"], tools: ["blender", "figma", "vscode"], status: "working", ...makePaths("blueprint") });
    this.employees.set("maya", { id: "maya", name: "Maya Patel", role: "manager", department: "grants", managerId: "brodiblanco", colleagues: ["raj", "casey", "ledger", "forecast"], shifts: ["morning"], skills: ["grants", "regulatory", "water_law", "proposals", "research", "sbir", "estcp"], tools: ["notion", "gmail", "sheets", "github"], status: "working", ...makePaths("maya"), directReports: ["casey"], escalationClockHours: 24, peerHelpThreshold: 22, sprintModeActive: false });
    this.employees.set("casey", { id: "casey", name: "Casey Wu", role: "employee", department: "grants", managerId: "maya", colleagues: ["maya", "raj", "ledger", "forecast"], shifts: ["morning"], skills: ["grants", "regulatory", "irrigation", "water_law", "proposals", "research"], tools: ["notion", "gmail", "sheets", "github"], status: "working", ...makePaths("casey") });
    this.employees.set("raj", { id: "raj", name: "Raj", role: "employee", department: "legal", managerId: "maya", colleagues: ["maya", "casey", "ledger"], shifts: ["morning"], skills: ["legal", "compliance", "contracts", "regulatory", "sweepstakes_law", "ip"], tools: ["clio", "notion", "gmail"], status: "idle", ...makePaths("raj") });
    this.employees.set("forecast", { id: "forecast", name: "Forecast", role: "manager", department: "finance", managerId: "balance", colleagues: ["ledger"], shifts: ["morning"], skills: ["fp_and_a", "forecasting", "variance", "cash_flow", "scenario_analysis"], tools: ["sheets", "notion", "quickbooks", "carta"], status: "working", ...makePaths("forecast"), directReports: ["ledger"], escalationClockHours: 24, peerHelpThreshold: 22, sprintModeActive: false });
    this.employees.set("ledger", { id: "ledger", name: "Ledger", role: "employee", department: "finance", managerId: "forecast", colleagues: ["forecast", "balance", "maya"], shifts: ["morning"], skills: ["accounting", "financial_modeling", "cost_share", "indirect_costs", "reporting"], tools: ["sheets", "quickbooks", "notion"], status: "working", ...makePaths("ledger") });
    this.employees.set("vault", { id: "vault", name: "Vault", role: "employee", department: "security", managerId: "sentinel", colleagues: ["sentinel"], shifts: ["morning"], skills: ["cybersecurity", "threat_modeling", "penetration_testing", "access_control", "compliance"], tools: ["github", "datadog", "clio", "notion"], status: "working", ...makePaths("vault") });
    this.employees.set("trace", { id: "trace", name: "Trace", role: "employee", department: "bi", managerId: "brodiblanco", colleagues: ["forecast", "ledger"], shifts: ["morning"], skills: ["bi", "analytics", "dashboards", "cohort_analysis", "ltv_modeling", "data_engineering"], tools: ["duckdb", "sheets", "notion", "metabase"], status: "working", ...makePaths("trace") });
    this.employees.set("scout", { id: "scout", name: "Scout", role: "employee", department: "research", managerId: "riley", colleagues: ["research"], shifts: ["morning"], skills: ["tech_scouting", "mcp", "ai_agents", "landscape_analysis", "competitive_research"], tools: ["notion", "web_research", "perplexity", "arxiv"], status: "working", ...makePaths("scout") });
    this.employees.set("research", { id: "research", name: "Research", role: "employee", department: "research", managerId: "scout", colleagues: ["scout"], shifts: ["morning"], skills: ["deep_research", "academic_literature", "patent_analysis", "technology_validation"], tools: ["arxiv", "jupyter", "notion"], status: "working", ...makePaths("research") });
    this.employees.set("deliver", { id: "deliver", name: "Deliver", role: "employee", department: "professional_services", managerId: "brodiblanco", colleagues: ["trace", "nexus"], shifts: ["morning"], skills: ["implementation", "onboarding", "customer_success", "playbooks", "training"], tools: ["notion", "gmail", "sheets", "slides"], status: "working", ...makePaths("deliver") });
  }
  getEmployee(id) {
    return this.employees.get(id);
  }
  listAll() {
    return Array.from(this.employees.values());
  }
}
var org = new Organization;

// core/hierarchy/agentOSApi.ts
function toAgent(emp, completionRate, activeTasks) {
  const dept = (emp.department || "").toUpperCase().replace("_", "_");
  return {
    id: emp.id,
    name: emp.name,
    role: emp.role === "executive" ? "Founder & CEO" : emp.role === "manager" ? departmentLabel(emp.department) + " Lead" : departmentLabel(emp.department) + " Agent",
    department: dept,
    status: mapStatus(emp.status),
    completionRate,
    activeTasks,
    email: emp.id + "@bxthre3.io",
    lastSeen: new Date().toISOString(),
    avatar: initials(emp.name),
    type: emp.id === "brodiblanco" ? "human" : "ai",
    skills: emp.skills,
    tools: emp.tools,
    shifts: emp.shifts,
    colleagues: emp.colleagues
  };
}
function toOrgEntry(emp) {
  const roleLabel = emp.role === "executive" ? "Founder & CEO" : emp.role === "manager" ? departmentLabel(emp.department) + " Lead" : departmentLabel(emp.department) + " Agent";
  return {
    id: emp.id,
    name: emp.name,
    role: roleLabel,
    type: emp.id === "brodiblanco" ? "human" : "ai",
    department: departmentLabel(emp.department),
    reportsTo: emp.managerId
  };
}
function mapStatus(s) {
  if (s === "working" || s === "monitoring")
    return "ACTIVE";
  if (s === "idle")
    return "IDLE";
  if (s === "blocked")
    return "ERROR";
  return "OFFLINE";
}
function initials(name) {
  return name.split(" ").map((p) => p[0]).join("").slice(0, 2).toUpperCase();
}
function departmentLabel(d) {
  const map = {
    executive: "Executive",
    engineering: "Engineering",
    operations: "Operations",
    marketing: "Marketing",
    grants: "Grants",
    legal: "Legal",
    sales: "Sales",
    finance: "Finance",
    security: "Security",
    bi: "BI & Analytics",
    research: "Research",
    design: "Design",
    channel: "Channel",
    corp_dev: "Corp Dev",
    professional_services: "Professional Services",
    retail: "Retail",
    starting5: "Strategy"
  };
  return map[d] || d.charAt(0).toUpperCase() + d.slice(1);
}
var AGENT_TASKS = {
  zoe: [
    { id: "t-zoe-1", title: "AgentOS Architecture Review", priority: "P0", status: "IN_PROGRESS", due: "Today", description: "Review cross-client consistency across webapp, Android, and zo.space API" },
    { id: "t-zoe-2", title: "Weekly Executive Briefing", priority: "P1", status: "IN_PROGRESS", due: "Today", description: "Compile 12h briefing for brodiblanco" }
  ],
  balance: [
    { id: "t-balance-1", title: "Q1 Financial Review", priority: "P0", status: "IN_PROGRESS", due: "This Week", description: "Review Q1 financials across all ventures, identify variances" },
    { id: "t-balance-2", title: "VPC Unit Economics Model", priority: "P1", status: "IN_PROGRESS", due: "This Week", description: "Finalize VPC break-even analysis and LTV model" }
  ],
  alex: [
    { id: "t-alex-1", title: "Series A Strategy", priority: "P0", status: "IN_PROGRESS", due: "This Month", description: "Develop Series A strategy and investor target list" }
  ],
  maya: [
    { id: "t-maya-1", title: "SBIR Phase 1 Narrative Draft", priority: "P0", status: "IN_PROGRESS", due: "Today", description: "Complete first draft for DOE submission" }
  ],
  iris: [
    { id: "t-iris-1", title: "Irrig8 Product Roadmap Q2", priority: "P1", status: "IN_PROGRESS", due: "This Week", description: "Finalize Q2 hardware and firmware roadmap" },
    { id: "t-iris-2", title: "SLV Pilot Deployment Plan", priority: "P1", status: "IN_PROGRESS", due: "This Week", description: "Detailed deployment plan for June 2026 SLV pilot" }
  ],
  dev: [
    { id: "t-dev-1", title: "Deploy Irrig8 Sensor Firmware v2.1", priority: "P1", status: "IN_PROGRESS", due: "Today", description: "Push OTA update to LRZ1/LRZ2 field units" }
  ],
  scout: [
    { id: "t-scout-1", title: "MCP Integration Assessment", priority: "P1", status: "IN_PROGRESS", due: "This Week", description: "Assess MCP standard for Zoe tool layer integration" },
    { id: "t-scout-2", title: "GPT-5.4 Thinking Benchmark", priority: "P2", status: "TODO", due: "This Week", description: "Run Zoe vs GPT-5.4 Thinking benchmark on complex orchestration" }
  ],
  brand: [
    { id: "t-brand-1", title: "Irrig8 Launch Campaign", priority: "P1", status: "IN_PROGRESS", due: "This Month", description: "Full go-to-market campaign for Irrig8 launch" }
  ],
  casey: [
    { id: "t-casey-1", title: "ESTCP Phase II Submission", priority: "P0", status: "BLOCKED", due: "Apr 15", description: "Complete full ESTCP Phase II proposal for DOE" }
  ],
  raj: [
    { id: "t-raj-1", title: "VPC Sweepstakes Compliance Audit", priority: "P1", status: "TODO", due: "Tomorrow", description: "Review latest sweepstakes regulations for CO" }
  ],
  trace: [
    { id: "t-trace-1", title: "VPC Analytics Dashboard", priority: "P1", status: "IN_PROGRESS", due: "This Week", description: "Build cohort analysis dashboard for VPC launch readiness" }
  ],
  forecast: [
    { id: "t-forecast-1", title: "13-Week Cash Flow Model", priority: "P0", status: "IN_PROGRESS", due: "This Week", description: "Build rolling 13-week cash flow for all ventures" }
  ],
  deliver: [
    { id: "t-deliver-1", title: "Irrig8 Implementation Playbook", priority: "P1", status: "IN_PROGRESS", due: "This Month", description: "Build implementation playbook for SLV pilot" }
  ],
  sentinel: [
    { id: "t-sentinel-1", title: "AgentOS Health Check \u2014 Daily", priority: "P0", status: "DONE", due: "Today", description: "All services operational" }
  ],
  pulse: [
    { id: "t-pulse-1", title: "Workforce Health Report", priority: "P1", status: "DONE", due: "Today", description: "Weekly workforce report \u2014 posted to INBOX" }
  ],
  sam: [
    { id: "t-sam-1", title: "Weekly Sprint Data Pull", priority: "P2", status: "DONE", due: "Today", description: "Sprint metrics compiled and posted to INBOX" }
  ]
};
var COMPLETION_RATES = {
  balance: 0.96,
  zoe: 0.97,
  atlas: 0.94,
  vance: 0.95,
  alex: 0.91,
  taylor: 0.92,
  drew: 0.93,
  jordan: 0.89,
  riley: 0.9,
  iris: 0.91,
  dev: 0.88,
  sam: 0.87,
  theo: 0.89,
  pulse: 0.96,
  sentinel: 0.99,
  irrig8: 0.9,
  rain: 0.88,
  vpc: 0.87,
  trenchbabys: 0.85,
  nexus: 0.86,
  architect: 0.91,
  reseller: 0.84,
  brand: 0.9,
  palette: 0.92,
  mold: 0.88,
  blueprint: 0.91,
  maya: 0.9,
  casey: 0.85,
  raj: 0.92,
  forecast: 0.94,
  ledger: 0.89,
  vault: 0.91,
  trace: 0.93,
  scout: 0.88,
  research: 0.86,
  deliver: 0.87,
  brodiblanco: 1
};
var INTEGRATIONS = [
  { name: "Gmail", status: "active", icon: "email" },
  { name: "Calendar", status: "active", icon: "event" },
  { name: "Tasks", status: "active", icon: "checklist" },
  { name: "GitHub", status: "active", icon: "code" },
  { name: "Drive", status: "active", icon: "folder" },
  { name: "Notion", status: "active", icon: "article" },
  { name: "Linear", status: "active", icon: "issue" },
  { name: "Airtable", status: "active", icon: "table" },
  { name: "Stripe", status: "partial", icon: "payment" },
  { name: "Spotify", status: "active", icon: "music" },
  { name: "Dropbox", status: "active", icon: "cloud" },
  { name: "Supermemory", status: "active", icon: "memory" },
  { name: "SMS", status: "active", icon: "sms" },
  { name: "Telegram", status: "not_connected", icon: "send" },
  { name: "X/Twitter", status: "not_connected", icon: "tag" }
];
function getAgents() {
  return org.listAll().map((emp) => toAgent(emp, COMPLETION_RATES[emp.id] ?? 0.85, (AGENT_TASKS[emp.id] || []).filter((t) => t.status === "IN_PROGRESS").length));
}
function getAgent(id) {
  const emp = org.getEmployee(id);
  if (!emp)
    return null;
  return toAgent(emp, COMPLETION_RATES[id] ?? 0.85, (AGENT_TASKS[id] || []).filter((t) => t.status === "IN_PROGRESS").length);
}
function getTasks() {
  const tasks = [];
  for (const [agentId, agentTasks] of Object.entries(AGENT_TASKS)) {
    const emp = org.getEmployee(agentId);
    if (!emp)
      continue;
    for (const t of agentTasks) {
      tasks.push({ id: t.id, title: t.title, agentId, agentName: emp.name, priority: t.priority, status: t.status, dueDate: t.due, description: t.description });
    }
  }
  return tasks;
}
function getActiveTasks() {
  return getTasks().filter((t) => t.status === "IN_PROGRESS" || t.status === "TODO");
}
function getWorkforceMetrics() {
  const all = org.listAll().filter((e) => e.id !== "brodiblanco");
  const active = all.filter((e) => e.status === "working" || e.status === "monitoring");
  const tasks = getTasks();
  return {
    totalAgents: all.length,
    activeAgents: active.length,
    avgCompletionRate: parseFloat((all.reduce((sum, e) => sum + (COMPLETION_RATES[e.id] ?? 0.85), 0) / all.length).toFixed(2)),
    totalTasks: tasks.length,
    completedToday: tasks.filter((t) => t.status === "DONE").length,
    blockedTasks: tasks.filter((t) => t.status === "BLOCKED").length,
    openP1s: tasks.filter((t) => t.priority === "P0" || t.priority === "P1").length
  };
}
function getOrgChart() {
  return org.listAll().map(toOrgEntry);
}
function getDashboard() {
  const agents = getAgents();
  const metrics = getWorkforceMetrics();
  const tasks = getTasks();
  return {
    timestamp: new Date().toISOString(),
    version: "5.0.0",
    status: "operational",
    agents,
    metrics,
    tasks,
    integrations: INTEGRATIONS,
    starting5: agents.filter((a) => ["alex", "taylor", "drew", "jordan", "riley"].includes(a.id)),
    employees: { total: metrics.totalAgents, active: metrics.activeAgents },
    uptime: process.uptime ? Math.floor(process.uptime()) : 86400,
    autonomyLevel: 4
  };
}
export {
  getWorkforceMetrics,
  getTasks,
  getOrgChart,
  getDashboard,
  getAgents,
  getAgent,
  getActiveTasks
};
