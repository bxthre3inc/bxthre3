package com.bxthre3.agentos.network
import com.bxthre3.agentos.data.*
import com.google.gson.*
object ApiService {
    private const val BASE = "https://aos-brodiblanco.zocomputer.io/api/agentos"
    private val gson = Gson()
    fun fetchSystemHealth() = SystemHealth(
        agentCount=25, activeAgents=14, idleAgents=9, blockedAgents=2,
        workQueueDepth=7, escalationCount=3, avgHealth=0.87f,
        uptime="145 cycles", diskUsage=80,
        knownIssues=listOf("oracle.farmsense.io DOWN","farmsense-api restarted","disk 80%"))
    fun fetchAgents():List<Agent> = listOf(
        Agent("zoe","Zoe","Digital Assistant / UAO","Operations","standby",false,"2026-03-16T05:00Z",0.92f,146,listOf("24/7 assistant protocol ready"),listOf(),listOf(),null),
        Agent("maya","Maya","VP Engineering","Engineering","awake_processing",true,"2026-03-16T03:05Z",0.95f,33,listOf("Health endpoint corrected","Oracle removed"),listOf(),listOf(),null),
        Agent("drew","Drew","Senior Software Engineer","Engineering","awake_processing",true,"2026-03-16T01:50Z",0.88f,10,listOf("Heartbeat 110 wakeup"),listOf(),listOf(),null),
        Agent("raj","Raj","VP of Operations","Operations","awake_processing",true,"2026-03-15T20:00Z",0.90f,8,listOf("20:00 UTC check complete"),listOf(),listOf(),"2026-03-15T21:00Z"),
        Agent("casey","Casey","Grant Coordinator","Grants","awake_processing",true,"2026-03-16T03:05Z",0.85f,11,listOf("ESTCP compiled"),listOf("Brand name decision pending"),listOf(),null),
        Agent("theo","Theo","Field Systems Engineer","Engineering","standby",false,"2026-03-16T05:00Z",0.78f,6,listOf("24/7 field monitor ready"),listOf(),listOf(),null),
        Agent("taylor","Taylor","Investor Relations Manager","Sales","standby",false,"2026-03-16T05:00Z",0.82f,6,listOf("Monday schedule ready"),listOf(),listOf(),null),
        Agent("sam","Sam","VP of Finance & Fundraising","Finance","standby",false,"2026-03-16T05:00Z",0.91f,5,listOf("2x daily check due"),listOf(),listOf(),null),
        Agent("iris","Iris","IP & Patent Specialist","Legal","awakened",false,"2026-03-16T17:00Z",0.76f,58,listOf(),listOf(),listOf(),"2026-03-16T17:15Z"),
        Agent("sentinel","Sentinel","IP and Security Monitor","Security","awakened",false,"2026-03-16T17:00Z",0.89f,66,listOf(),listOf(),listOf(),"2026-03-16T17:15Z"),
        Agent("pulse","Pulse","System Health Monitor","Operations","awakened",false,"2026-03-16T17:00Z",0.97f,334,listOf("Heartbeat cycle 164 complete"),listOf(),listOf(),"2026-03-16T17:15Z"),
        Agent("chronicler","Chronicler","Activity Logger","Operations","awakened",false,"2026-03-16T17:00Z",0.73f,174,listOf(),listOf(),listOf(),"2026-03-16T17:15Z"),
        Agent("avery","Avery","Orchestrator","Operations","active",false,"2026-03-16T10:10Z",0.94f,141,listOf("Heartbeat 141 complete","ESTCP deadline 10 days"),listOf("oracle endpoint removed"),listOf(),null),
        Agent("quinn","Quinn","Fundraising Analyst","Finance","awake_processing",true,"2026-03-15T23:05Z",0.80f,8,listOf("Cycle complete"),listOf(),listOf(),null),
        Agent("remy","Remy","Memory Analyst","Operations","complete",false,"2026-03-15T17:00Z",0.85f,0,listOf("7-day pattern analysis","3 P1 escalations flagged"),listOf("3 P1 blocked 21+ hours"),listOf("P1 bottleneck confirmed"),null),
        Agent("alex","Alex","Content & Documentation","Marketing","awake_processing",true,"2026-03-15T20:00Z",0.71f,3,listOf("Shift complete","No content tasks pending"),listOf(),listOf(),null),
        Agent("riley","Riley","Corporate Secretary","Legal","idle",false,"2026-03-14T20:15Z",0.69f,2,listOf("No governance tasks pending"),listOf(),listOf(),null),
        Agent("architect","Architect","Enterprise Architect","Strategy","active",true,"2026-03-16T10:00Z",0.88f,0,listOf("Blueprint v3 complete"),listOf(),listOf(),null),
        Agent("brand","Brand","Brand Strategist","Marketing","active",true,"2026-03-16T09:00Z",0.75f,0,listOf("Irrig8 rebrand executed"),listOf("FarmSense retirement"),listOf(),null),
        Agent("blueprint","Blueprint","Product Architect","Product","active",true,"2026-03-16T08:00Z",0.82f,0,listOf("Feature specs v2"),listOf(),listOf(),null),
        Agent("sync","Sync","Integration Engineer","Engineering","active",true,"2026-03-16T11:00Z",0.91f,0,listOf("Airtable, Notion, Linear connected"),listOf(),listOf(),null),
        Agent("navigate","Navigate","Product Strategy","Product","active",true,"2026-03-16T10:30Z",0.79f,0,listOf("Growth roadmap complete"),listOf(),listOf(),null),
        Agent("vault","Vault","Security Engineer","Security","active",true,"2026-03-16T09:30Z",0.86f,0,listOf("Threat model updated"),listOf(),listOf(),null),
        Agent("trace","Trace","Audit & Compliance","Compliance","active",true,"2026-03-16T10:00Z",0.77f,0,listOf("Audit trail v2"),listOf(),listOf(),null),
        Agent("nexus","Nexus","Partnerships Lead","Sales","active",true,"2026-03-16T10:00Z",0.83f,0,listOf("3 partnership conversations"),listOf(),listOf(),null))
    fun fetchDepts():List<Dept> = listOf(
        Dept("engineering","Engineering","Maya",listOf("drew","theo","sync"),mapOf("velocity" to 0.85,"openTasks" to 4,"bugs" to 2),listOf("Irrig8 sensor firmware","VPC platform v2","AgentOS v4"),2),
        Dept("operations","Operations","Raj",listOf("pulse","chronicler","avery","remy","zoe"),mapOf("cycles" to 334,"health" to 0.97,"alerts" to 7),listOf("Heartbeat protocol","Work queue routing","Agent orchestration"),1),
        Dept("grants","Grants","Raj",listOf("casey"),mapOf("estcp" to "compiled","daysLeft" to 10,"blockers" to 1),listOf("ESTCP Grant","SBIR Phase II"),1),
        Dept("finance","Finance","Sam",listOf("quinn"),mapOf("burnRate" to 4200,"runway" to "8 months","raised" to 0),listOf("Investor deck","Term sheet"),0),
        Dept("sales","Sales","Taylor",listOf("nexus"),mapOf("leads" to 12,"meetings" to 3,"pipeline" to 85000),listOf("VPC cash partners","Irrig8 pilots"),0),
        Dept("legal","Legal","Riley",listOf("iris","sentinel","trace","vault"),mapOf("ipFilings" to 3,"escrow" to "active","compliance" to "green"),listOf("Patent pending","Trademark watch"),0),
        Dept("marketing","Marketing","Alex",listOf("brand"),mapOf("contentPieces" to 8,"leads" to 23,"social" to 1450),listOf("Irrig8 launch","VPC investor deck"),0),
        Dept("product","Product","Blueprint",listOf("navigate"),mapOf("features" to 12,"roadmapQ2" to 18,"experiments" to 3),listOf("Starting5 SaaS","Rain v2"),0),
        Dept("security","Security","Sentinel",listOf("vault","trace"),mapOf("threats" to 0,"incidents" to 0,"patchRate" to "98%"),listOf("SOC 2 preparation","GDPR review"),0),
        Dept("strategy","Strategy","Architect",listOf("blueprint"),mapOf("deals" to 2,"mrr" to 0,"target" to 500000),listOf("802 Morton deal","VPC equity round"),0),
        Dept("compliance","Compliance","Trace",listOf(),mapOf("audits" to 1,"findings" to 0,"policyVersion" to "2.1"),listOf("Annual audit"),0),
        Dept("hr","HR","Remy",listOf(),mapOf("agents" to 25,"openRoles" to 0,"offboardings" to 0),listOf("Performance reviews"),0),
        Dept("funding","Funding","Quinn",listOf("sam"),mapOf("raised" to 0,"target" to 250000,"burnRate" to 4200),listOf("Pre-seed round","Grant stacking"),0),
        Dept("integrations","Integrations","Sync",listOf(),mapOf("connected" to 10,"pending" to 2,"errors" to 0),listOf("Telegram setup","Twitter OAuth"),0))
    fun fetchIntegrations():List<Integration> = listOf(
        Integration("gmail","Gmail","Connected","2026-03-16T17:00Z","email",listOf("Send","Read","Search")),
        Integration("calendar","Google Calendar","Connected","2026-03-16T16:30Z","event",listOf("Create","Read","Update")),
        Integration("tasks","Google Tasks","Connected","2026-03-16T17:00Z","checklist",listOf("CRUD operations")),
        Integration("drive","Google Drive","Connected","2026-03-16T15:00Z","folder",listOf("Upload","Download","Share")),
        Integration("notion","Notion","Connected","2026-03-16T14:00Z","article",listOf("Read pages","Update databases")),
        Integration("airtable","Airtable","Connected","2026-03-16T16:00Z","table",listOf("CRUD records","Sync tables")),
        Integration("linear","Linear","Connected","2026-03-16T17:00Z","issue",listOf("Create issues","Update status")),
        Integration("stripe","Stripe","Partial","2026-03-16T10:00Z","credit_card",listOf("VPC payments","Investor transactions")),
        Integration("spotify","Spotify","Connected","2026-03-16T12:00Z","music",listOf("Play","Pause","Search")),
        Integration("dropbox","Dropbox","Connected","2026-03-16T14:00Z","cloud",listOf("Upload","Download")),
        Integration("github","GitHub","Connected","2026-03-16T16:45Z","code",listOf("PR review","Issue management")),
        Integration("telegram","Telegram","Not Connected","—","send",listOf("Alerts","Notifications")),
        Integration("twitter","X/Twitter","Not Connected","—","tag",listOf("Social monitoring")))
    fun fetchStarting5():List<Starting5> = listOf(
        Starting5("Alex Morgan","Visionary","Corporate Strategy","ESTCP grant brand decision",mapOf("insights" to 12,"decisions" to 3,"patience_score" to 0.82),"active"),
        Starting5("Taylor Chen","Builder","Platform Engineering","Irrig8 sensor integration",mapOf("commits" to 47,"prs" to 12,"code_review_time" to "2.4h"),"active"),
        Starting5("Morgan Blake","Operator","Business Operations","VPC cash partner onboarding",mapOf("tasks_completed" to 89,"blockers_resolved" to 15,"automation_rate" to 0.78),"active"),
        Starting5("Jordan Reyes","Hunter","Business Development","VPC founding investor outreach",mapOf("calls" to 23,"demos_scheduled" to 8,"close_rate" to 0.15),"active"),
        Starting5("Riley Park","Architect","Product Design","Starting5 SaaS feature spec",mapOf("specs" to 6,"user_stories" to 34,"epics" to 3),"active"))
    fun fetchEscalations():List<Escalation> = listOf(
        Escalation("esc-001","remy","3 P1 escalations blocked 21+ hours — brodiblanco bottleneck","P1",21,"open"),
        Escalation("esc-002","casey","Brand name decision pending — ESTCP deadline March 26","P1",48,"open"),
        Escalation("esc-003","maya","Oracle endpoint decision deadline passed","P1",72,"open"),
        Escalation("esc-004","avery","Disk space 80% — infrastructure threshold","P2",6,"monitoring"),
        Escalation("esc-005","zoe","oracle.farmsense.io DOWN since March 10","P2",144,"monitoring"))
    fun fetchWorkQueue():List<WorkItem> = listOf(
        WorkItem("wq-001","avery","ESTCP Grant Proposal submission","P1","in_progress","2026-03-10","Brand decision"),
        WorkItem("wq-002","maya","Portal DNS decision — zo.computer URLs","P1","blocked","2026-03-14","Await brodiblanco"),
        WorkItem("wq-003","sync","Telegram integration setup","P2","pending","2026-03-15","OAuth pending"),
        WorkItem("wq-004","brand","VPC investor deck finalization","P2","in_progress","2026-03-16","Await feedback"),
        WorkItem("wq-005","nexus","Cash partner outreach — 3 warm leads","P2","pending","2026-03-16","None"),
        WorkItem("wq-006","blueprint","Starting5 SaaS pricing model","P2","pending","2026-03-16","Finance review"),
        WorkItem("wq-007","architect","802 Morton deal due diligence","P1","in_progress","2026-03-14","Legal review"))
}
