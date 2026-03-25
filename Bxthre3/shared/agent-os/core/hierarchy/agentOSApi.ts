import { org } from './org.js';
import type { Employee, Manager, Executive } from './types';

function toAgent(emp: Employee | Manager | Executive, completionRate: number, activeTasks: number) {
  const dept = (emp.department || '').toUpperCase().replace('_', '_') as string;
  return {
    id: emp.id,
    name: emp.name,
    role: emp.role === 'executive' ? 'Founder & CEO' :
          emp.role === 'manager' ? departmentLabel(emp.department) + ' Lead' :
          departmentLabel(emp.department) + ' Agent',
    department: dept,
    status: mapStatus(emp.status),
    completionRate,
    activeTasks,
    email: emp.id + '@bxthre3.io',
    lastSeen: new Date().toISOString(),
    avatar: initials(emp.name),
    type: emp.id === 'brodiblanco' ? 'human' : 'ai',
    skills: emp.skills,
    tools: emp.tools,
    shifts: emp.shifts,
    colleagues: emp.colleagues,
  };
}

function toOrgEntry(emp: Employee | Manager | Executive) {
  const roleLabel = emp.role === 'executive' ? 'Founder & CEO' :
    emp.role === 'manager' ? departmentLabel(emp.department) + ' Lead' :
    departmentLabel(emp.department) + ' Agent';
  return {
    id: emp.id, name: emp.name, role: roleLabel,
    type: emp.id === 'brodiblanco' ? 'human' : 'ai',
    department: departmentLabel(emp.department),
    reportsTo: emp.managerId,
  };
}

function mapStatus(s: string): 'ACTIVE' | 'IDLE' | 'OFFLINE' | 'ERROR' {
  if (s === 'working' || s === 'monitoring') return 'ACTIVE';
  if (s === 'idle') return 'IDLE';
  if (s === 'blocked') return 'ERROR';
  return 'OFFLINE';
}

function initials(name: string): string {
  return name.split(' ').map(p => p[0]).join('').slice(0, 2).toUpperCase();
}

function departmentLabel(d: string): string {
  const map: Record<string, string> = {
    executive:'Executive', engineering:'Engineering', operations:'Operations',
    marketing:'Marketing', grants:'Grants', legal:'Legal', sales:'Sales',
    finance:'Finance', security:'Security', bi:'BI & Analytics',
    research:'Research', design:'Design', channel:'Channel',
    corp_dev:'Corp Dev', professional_services:'Professional Services',
    retail:'Retail', starting5:'Strategy',
  };
  return map[d] || d.charAt(0).toUpperCase() + d.slice(1);
}

const AGENT_TASKS: Record<string, Array<{id:string;title:string;priority:string;status:string;due:string;description:string}>> = {
  zoe:[
    {id:'t-zoe-1',title:'AgentOS Architecture Review',priority:'P0',status:'IN_PROGRESS',due:'Today',description:'Review cross-client consistency across webapp, Android, and zo.space API'},
    {id:'t-zoe-2',title:'Weekly Executive Briefing',priority:'P1',status:'IN_PROGRESS',due:'Today',description:'Compile 12h briefing for brodiblanco'},
  ],
  balance:[
    {id:'t-balance-1',title:'Q1 Financial Review',priority:'P0',status:'IN_PROGRESS',due:'This Week',description:'Review Q1 financials across all ventures, identify variances'},
    {id:'t-balance-2',title:'VPC Unit Economics Model',priority:'P1',status:'IN_PROGRESS',due:'This Week',description:'Finalize VPC break-even analysis and LTV model'},
  ],
  alex:[
    {id:'t-alex-1',title:'Series A Strategy',priority:'P0',status:'IN_PROGRESS',due:'This Month',description:'Develop Series A strategy and investor target list'},
  ],
  maya:[
    {id:'t-maya-1',title:'SBIR Phase 1 Narrative Draft',priority:'P0',status:'IN_PROGRESS',due:'Today',description:'Complete first draft for DOE submission'},
  ],
  iris:[
    {id:'t-iris-1',title:'Irrig8 Product Roadmap Q2',priority:'P1',status:'IN_PROGRESS',due:'This Week',description:'Finalize Q2 hardware and firmware roadmap'},
    {id:'t-iris-2',title:'SLV Pilot Deployment Plan',priority:'P1',status:'IN_PROGRESS',due:'This Week',description:'Detailed deployment plan for June 2026 SLV pilot'},
  ],
  dev:[
    {id:'t-dev-1',title:'Deploy Irrig8 Sensor Firmware v2.1',priority:'P1',status:'IN_PROGRESS',due:'Today',description:'Push OTA update to LRZ1/LRZ2 field units'},
  ],
  scout:[
    {id:'t-scout-1',title:'MCP Integration Assessment',priority:'P1',status:'IN_PROGRESS',due:'This Week',description:'Assess MCP standard for Zoe tool layer integration'},
    {id:'t-scout-2',title:'GPT-5.4 Thinking Benchmark',priority:'P2',status:'TODO',due:'This Week',description:'Run Zoe vs GPT-5.4 Thinking benchmark on complex orchestration'},
  ],
  brand:[
    {id:'t-brand-1',title:'Irrig8 Launch Campaign',priority:'P1',status:'IN_PROGRESS',due:'This Month',description:'Full go-to-market campaign for Irrig8 launch'},
  ],
  casey:[
    {id:'t-casey-1',title:'ESTCP Phase II Submission',priority:'P0',status:'BLOCKED',due:'Apr 15',description:'Complete full ESTCP Phase II proposal for DOE'},
  ],
  raj:[
    {id:'t-raj-1',title:'VPC Sweepstakes Compliance Audit',priority:'P1',status:'TODO',due:'Tomorrow',description:'Review latest sweepstakes regulations for CO'},
  ],
  trace:[
    {id:'t-trace-1',title:'VPC Analytics Dashboard',priority:'P1',status:'IN_PROGRESS',due:'This Week',description:'Build cohort analysis dashboard for VPC launch readiness'},
  ],
  forecast:[
    {id:'t-forecast-1',title:'13-Week Cash Flow Model',priority:'P0',status:'IN_PROGRESS',due:'This Week',description:'Build rolling 13-week cash flow for all ventures'},
  ],
  deliver:[
    {id:'t-deliver-1',title:'Irrig8 Implementation Playbook',priority:'P1',status:'IN_PROGRESS',due:'This Month',description:'Build implementation playbook for SLV pilot'},
  ],
  sentinel:[
    {id:'t-sentinel-1',title:'AgentOS Health Check — Daily',priority:'P0',status:'DONE',due:'Today',description:'All services operational'},
  ],
  pulse:[
    {id:'t-pulse-1',title:'Workforce Health Report',priority:'P1',status:'DONE',due:'Today',description:'Weekly workforce report — posted to INBOX'},
  ],
  sam:[
    {id:'t-sam-1',title:'Weekly Sprint Data Pull',priority:'P2',status:'DONE',due:'Today',description:'Sprint metrics compiled and posted to INBOX'},
  ],
};

const COMPLETION_RATES: Record<string, number> = {
  balance:0.96, zoe:0.97, atlas:0.94, vance:0.95,
  alex:0.91, taylor:0.92, drew:0.93, jordan:0.89, riley:0.90,
  iris:0.91, dev:0.88, sam:0.87, theo:0.89,
  pulse:0.96, sentinel:0.99, irrig8:0.90, rain:0.88, vpc:0.87, trenchbabys:0.85,
  nexus:0.86, architect:0.91, reseller:0.84,
  brand:0.90, palette:0.92, mold:0.88, blueprint:0.91,
  maya:0.90, casey:0.85, raj:0.92,
  forecast:0.94, ledger:0.89,
  vault:0.91, trace:0.93, scout:0.88, research:0.86, deliver:0.87,
  brodiblanco:1.0,
};

const INTEGRATIONS = [
  {name:'Gmail',status:'active',icon:'email'},
  {name:'Calendar',status:'active',icon:'event'},
  {name:'Tasks',status:'active',icon:'checklist'},
  {name:'GitHub',status:'active',icon:'code'},
  {name:'Drive',status:'active',icon:'folder'},
  {name:'Notion',status:'active',icon:'article'},
  {name:'Linear',status:'active',icon:'issue'},
  {name:'Airtable',status:'active',icon:'table'},
  {name:'Stripe',status:'partial',icon:'payment'},
  {name:'Spotify',status:'active',icon:'music'},
  {name:'Dropbox',status:'active',icon:'cloud'},
  {name:'Supermemory',status:'active',icon:'memory'},
  {name:'SMS',status:'active',icon:'sms'},
  {name:'Telegram',status:'not_connected',icon:'send'},
  {name:'X/Twitter',status:'not_connected',icon:'tag'},
];

export function getAgents() {
  return org.listAll().map(emp => toAgent(emp,
    COMPLETION_RATES[emp.id] ?? 0.85,
    (AGENT_TASKS[emp.id] || []).filter(t => t.status === 'IN_PROGRESS').length
  ));
}

export function getAgent(id: string) {
  const emp = org.getEmployee(id);
  if (!emp) return null;
  return toAgent(emp, COMPLETION_RATES[id] ?? 0.85, (AGENT_TASKS[id] || []).filter(t => t.status === 'IN_PROGRESS').length);
}

export function getTasks() {
  const tasks: Array<{id:string;title:string;agentId:string;agentName:string;priority:string;status:string;dueDate:string;description:string}> = [];
  for (const [agentId, agentTasks] of Object.entries(AGENT_TASKS)) {
    const emp = org.getEmployee(agentId);
    if (!emp) continue;
    for (const t of agentTasks) {
      tasks.push({id:t.id,title:t.title,agentId,agentName:emp.name,priority:t.priority,status:t.status,dueDate:t.due,description:t.description});
    }
  }
  return tasks;
}

export function getActiveTasks() {
  return getTasks().filter(t => t.status === 'IN_PROGRESS' || t.status === 'TODO');
}

export function getWorkforceMetrics() {
  const all = org.listAll().filter(e => e.id !== 'brodiblanco');
  const active = all.filter(e => e.status === 'working' || e.status === 'monitoring');
  const tasks = getTasks();
  return {
    totalAgents: all.length,
    activeAgents: active.length,
    avgCompletionRate: parseFloat((all.reduce((sum, e) => sum + (COMPLETION_RATES[e.id] ?? 0.85), 0) / all.length).toFixed(2)),
    totalTasks: tasks.length,
    completedToday: tasks.filter(t => t.status === 'DONE').length,
    blockedTasks: tasks.filter(t => t.status === 'BLOCKED').length,
    openP1s: tasks.filter(t => t.priority === 'P0' || t.priority === 'P1').length,
  };
}

export function getOrgChart() {
  return org.listAll().map(toOrgEntry);
}

export function getDashboard() {
  const agents = getAgents();
  const metrics = getWorkforceMetrics();
  const tasks = getTasks();
  return {
    timestamp: new Date().toISOString(),
    version: '5.0.0',
    status: 'operational',
    agents,
    metrics,
    tasks,
    integrations: INTEGRATIONS,
    starting5: agents.filter(a => ['alex','taylor','drew','jordan','riley'].includes(a.id)),
    employees: { total: metrics.totalAgents, active: metrics.activeAgents },
    uptime: process.uptime ? Math.floor(process.uptime()) : 86400,
    autonomyLevel: 4,
  };
}
