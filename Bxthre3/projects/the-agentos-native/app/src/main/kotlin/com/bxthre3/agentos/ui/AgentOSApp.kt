package com.bxthre3.agentos.ui
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bxthre3.agentos.data.*
import com.bxthre3.agentos.network.ApiService
import com.bxthre3.agentos.ui.theme.*
data class Nav(val route:String,val label:String,val icon:String)
val NAV = listOf(Nav("dashboard","Dashboard","d"),Nav("workforce","Workforce","p"),Nav("depts","Depts","b"),Nav("queue","Queue","a"),Nav("integrations","Stack","c"),Nav("escalations","Esc","w"),Nav("starting5","S5","s"),Nav("reports","Reports","r"),Nav("projects","Projects","f"),Nav("settings","Settings","o"))
val DEPT_COLORS = mapOf("Engineering" to Accent,"Operations" to Color(0xFF38BDF8),"Grants" to Color(0xFFA78BFA),"Finance" to Color(0xFF34D399),"Sales" to Color(0xFFF59E0B),"Legal" to Color(0xFFEF4444),"Marketing" to Color(0xFFEC4899),"Product" to Color(0xFF06B6D4),"Security" to Color(0xFF84CC16),"Strategy" to Color(0xFFF97316),"Compliance" to Color(0xFF6366F1),"HR" to Color(0xFF14B8A6),"Funding" to Color(0xFFE11D48),"Integrations" to Color(0xFF8B5CF6))
@Composable fun AgentOSApp() {
  var tab by remember { mutableStateOf("dashboard") }
  Column(modifier=Modifier.fillMaxSize().background(Navy)) {
    TopAppBar(tab)
    LazyColumn(modifier=Modifier.weight(1f).padding(horizontal=12.dp), contentPadding=PaddingValues(vertical=8.dp)) { when(tab) { "dashboard"->item{ DashboardTab() }; "workforce"->item{ WorkforceTab() }; "depts"->item{ DeptsTab() }; "queue"->item{ QueueTab() }; "integrations"->item{ IntegrationsTab() }; "escalations"->item{ EscalationsTab() }; "starting5"->item{ Starting5Tab() }; "reports"->item{ ReportsTab() }; "projects"->item{ ProjectsTab() }; "settings"->item{ SettingsTab() }; else->item{} } }
    BottomNav(tab) { tab=it }
  }
}
@Composable fun TopAppBar(title:String) {
  val h = ApiService.fetchSystemHealth()
  Row(modifier=Modifier.fillMaxWidth().background(DarkBlue).padding(horizontal=16.dp,vertical=12.dp).statusBarsPadding(), verticalAlignment=Alignment.CenterVertically) {
    Text("AGENTOS", fontSize=18.sp, fontWeight=FontWeight.Black, color=Accent)
    Spacer(modifier=Modifier.width(12.dp))
    Text(title.uppercase(), fontSize=12.sp, color=Gray, modifier=Modifier.weight(1f))
    Text("${h.agentCount} agents", fontSize=11.sp, color=Accent)
  }
}
@Composable fun BottomNav(current:String, onSelect:(String)->Unit) {
  Row(modifier=Modifier.fillMaxWidth().background(DarkBlue).navigationBarsPadding().padding(vertical=6.dp), horizontalArrangement=Arrangement.SpaceEvenly) {
    NAV.forEach { n->Column(modifier=Modifier.clip(RoundedCornerShape(8.dp)).background(if(current==n.route) MidBlue else Color.Transparent).padding(horizontal=8.dp,vertical=4.dp).clickable{onSelect(n.route)}, horizontalAlignment=Alignment.CenterHorizontally) {
      Icon(when(n.icon){"d"->Icons.Default.Dashboard;"p"->Icons.Default.People;"b"->Icons.Default.Business;"a"->Icons.Default.Assignment;"c"->Icons.Default.Cloud;"w"->Icons.Default.Warning;"s"->Icons.Default.Star;"r"->Icons.Default.Assessment;"f"->Icons.Default.Folder;"o"->Icons.Default.Settings else->Icons.Default.Android}, null, tint=if(current==n.route) Accent else Gray, modifier=Modifier.size(22.dp))
      Text(n.label, fontSize=9.sp, color=if(current==n.route) White else Gray)
    } }
  }
}
@Composable fun StatCard(label:String,value:String,color:Color=White,subtitle:String="") { Column(modifier=Modifier.weight(1f).background(DarkBlue,RoundedCornerShape(12.dp)).padding(12.dp)){ Text(label,fontSize=10.sp,color=Gray); Text(value,fontSize=22.sp,fontWeight=FontWeight.Bold,color=color); if(subtitle.isNotEmpty()) Text(subtitle,fontSize=9.sp,color=Gray) } }
@Composable fun Section(title:String) { Text(title,fontSize=13.sp,fontWeight=FontWeight.Bold,color=Accent,modifier=Modifier.padding(vertical=8.dp)) }
@Composable fun AgentRow(agent:Agent) {
  val sc = when(agent.status){"awake_processing"->Accent;"active"->Color(0xFF38BDF8);"awakened"->Amber;"standby"->Gray;"idle"->Red;"complete"->Color(0xFF34D399);else->Gray}
  Row(modifier=Modifier.fillMaxWidth().background(DarkBlue,RoundedCornerShape(10.dp)).padding(12.dp), verticalAlignment=Alignment.CenterVertically) {
    Box(modifier=Modifier.size(36.dp).background(sc.copy(alpha=0.2f),CircleShape), contentAlignment=Alignment.Center){ Text(agent.name.take(2).uppercase(),fontSize=12.sp,fontWeight=FontWeight.Bold,color=sc) }
    Spacer(modifier=Modifier.width(10.dp))
    Column(modifier=Modifier.weight(1f)){ Text(agent.name,fontSize=14.sp,fontWeight=FontWeight.SemiBold,color=White); Text(agent.role,fontSize=11.sp,color=Gray,maxLines=1,overflow=TextOverflow.Ellipsis) }
    Column(horizontalAlignment=Alignment.End){ Text(agent.status.replace("_"," ").replace("awake ",""),fontSize=10.sp,color=sc,fontWeight=FontWeight.Medium); Text("WK:${agent.protocolWakeups}",fontSize=9.sp,color=Gray) }
  }
  Spacer(modifier=Modifier.height(6.dp))
}
@Composable fun DeptRow(dept:Dept) {
  val dc = DEPT_COLORS[dept.name] ?: Accent
  Card(modifier=Modifier.fillMaxWidth().padding(vertical=4.dp),colors=CardDefaults.cardColors(containerColor=DarkBlue),shape=RoundedCornerShape(12.dp)) {
    Column(modifier=Modifier.padding(14.dp)) {
      Row(verticalAlignment=Alignment.CenterVertically) {
        Box(modifier=Modifier.size(8.dp).background(dc,CircleShape))
        Spacer(modifier=Modifier.width(8.dp))
        Text(dept.name,fontSize=15.sp,fontWeight=FontWeight.Bold,color=White,modifier=Modifier.weight(1f))
        if(dept.escalationCount>0) Box(modifier=Modifier.background(Red.copy(alpha=0.2f),RoundedCornerShape(6.dp)).padding(horizontal=6.dp,vertical=2.dp)){ Text("${dept.escalationCount}",fontSize=10.sp,color=Red,fontWeight=FontWeight.Bold) }
      }
      Spacer(modifier=Modifier.height(6.dp))
      Text("Head: ${dept.head}  |  ${dept.agents.size} agents",fontSize=11.sp,color=Gray)
      Spacer(modifier=Modifier.height(4.dp))
      Row{ dept.agents.take(5).forEach{ a->Box(modifier=Modifier.padding(end=4.dp).background(MidBlue,RoundedCornerShape(4.dp)).padding(horizontal=6.dp,vertical=2.dp)){ Text(a,fontSize=9.sp,color=White) } } }
      if(dept.activeProjects.isNotEmpty()){ Spacer(modifier=Modifier.height(4.dp)); Text("Projects: ${dept.activeProjects.take(2).joinToString(", ")}",fontSize=10.sp,color=Gray,maxLines=1,overflow=TextOverflow.Ellipsis) }
    }
  }
}

@Composable fun DashboardTab() {
  val h = ApiService.fetchSystemHealth()
  val agents = ApiService.fetchAgents().take(10)
  Column {
    Row(modifier=Modifier.fillMaxWidth().padding(vertical=6.dp),horizontalArrangement=Arrangement.spacedBy(8.dp)){ StatCard("Active","${h.activeAgents}",Accent,"of ${h.agentCount} agents"); StatCard("Queue","${h.workQueueDepth}",Amber,"items pending") }
    Row(modifier=Modifier.fillMaxWidth().padding(vertical=6.dp),horizontalArrangement=Arrangement.spacedBy(8.dp)){ StatCard("Esc","${h.escalationCount}",Red,"P1 open"); StatCard("Health","${(h.avgHealth*100).toInt()}",Color(0xFF34D399),"avg score") }
    Section("System Status")
    Card(modifier=Modifier.fillMaxWidth(),colors=CardDefaults.cardColors(containerColor=DarkBlue),shape=RoundedCornerShape(12.dp)){ Column(modifier=Modifier.padding(14.dp)){ Row(modifier=Modifier.fillMaxWidth()){ Column(modifier=Modifier.weight(1f)){ Text("Uptime",fontSize=10.sp,color=Gray); Text(h.uptime,fontSize=13.sp,fontWeight=FontWeight.SemiBold,color=White) }; Column(modifier=Modifier.weight(1f)){ Text("Disk Usage",fontSize=10.sp,color=Gray); Text("${h.diskUsage}%",fontSize=13.sp,fontWeight=FontWeight.SemiBold,color=if(h.diskUsage>75) Amber else Accent) } }; Spacer(modifier=Modifier.height(8.dp)); h.knownIssues.forEach{ iss->Row(modifier=Modifier.padding(vertical=2.dp)){ Text("• ",color=Red,fontSize=12.sp); Text(iss,fontSize=11.sp,color=Gray) } } } }
    Section("Active Agents")
    agents.forEach{ AgentRow(it) }
  }
}
@Composable fun WorkforceTab() {
  val agents = ApiService.fetchAgents()
  var search by remember { mutableStateOf("") }
  var filter by remember { mutableStateOf("All") }
  val depts = listOf("All") + agents.map{it.dept}.distinct()
  Column {
    OutlinedTextField(search,{search=it},modifier=Modifier.fillMaxWidth().padding(vertical=4.dp),placeholder={Text("Search agents...")},singleLine=true,colors=OutlinedTextFieldDefaults.colors(focusedBorderColor=Accent,unfocusedBorderColor=Gray))
    LazyRow(modifier=Modifier.padding(vertical=4.dp)){ items(depts){d->Box(modifier=Modifier.padding(end=6.dp).clip(RoundedCornerShape(20.dp)).background(if(filter==d) Accent else MidBlue).padding(horizontal=12.dp,vertical=6.dp).clickable{filter=d}){ Text(d,fontSize=11.sp,color=if(filter==d) Navy else White) } } }
    val filtered = agents.filter{(filter=="All"||it.dept==filter)&&(search.isEmpty()||it.name.contains(search,true)||it.role.contains(search,true))}
    filtered.forEach{ AgentRow(it) }
    Text("${filtered.size} of ${agents.size} agents",fontSize=10.sp,color=Gray,modifier=Modifier.padding(vertical=8.dp))
  }
}
@Composable fun DeptsTab() { ApiService.fetchDepts().forEach{ DeptRow(it) } }
@Composable fun QueueTab() {
  ApiService.fetchWorkQueue().forEach{w->Card(modifier=Modifier.fillMaxWidth().padding(vertical=4.dp),colors=CardDefaults.cardColors(containerColor=DarkBlue),shape=RoundedCornerShape(10.dp)){ Column(modifier=Modifier.padding(12.dp)){ Row(modifier=Modifier.fillMaxWidth()){ val pc=when(w.priority){"P1"->Red;"P2"->Amber;else->Gray}; Text(w.priority,fontSize=11.sp,fontWeight=FontWeight.Bold,color=pc,modifier=Modifier.background(pc.copy(alpha=0.2f),RoundedCornerShape(4.dp)).padding(horizontal=6.dp,vertical=2.dp)); Spacer(modifier=Modifier.width(8.dp)); Text(w.agent,fontSize=12.sp,fontWeight=FontWeight.SemiBold,color=White,modifier=Modifier.weight(1f)); Text(w.status,fontSize=10.sp,color=when(w.status){"in_progress"->Accent;"blocked"->Red;"pending"->Gray;else->Amber}) }; Spacer(modifier=Modifier.height(4.dp)); Text(w.task,fontSize=13.sp,color=White); if(w.blockers.isNotEmpty()){Spacer(modifier=Modifier.height(4.dp));Text("Blocked: ${w.blockers}",fontSize=10.sp,color=Red)} } } }
}
@Composable fun IntegrationsTab() {
  val ints = ApiService.fetchIntegrations()
  Column {
    Row(modifier=Modifier.fillMaxWidth().padding(vertical=6.dp),horizontalArrangement=Arrangement.spacedBy(8.dp)){ StatCard("Connected","${ints.count{it.status=="Connected"}}",Accent); StatCard("Partial","${ints.count{it.status=="Partial"}}",Amber); StatCard("Offline","${ints.count{it.status=="Not Connected"}}",Red) }
    ints.forEach{i->
      val sc=when(i.status){"Connected"->Accent;"Partial"->Amber;else->Red}
      Card(modifier=Modifier.fillMaxWidth().padding(vertical=3.dp),colors=CardDefaults.cardColors(containerColor=DarkBlue),shape=RoundedCornerShape(10.dp)){
        Row(modifier=Modifier.padding(12.dp),verticalAlignment=Alignment.CenterVertically){
          Icon(when(i.icon){"email"->Icons.Default.Email;"event"->Icons.Default.Event;"checklist"->Icons.Default.Checklist;"folder"->Icons.Default.Folder;"article"->Icons.Default.Article;"table"->Icons.Default.TableChart;"issue"->Icons.Default.IssueMarker;"credit_card"->Icons.Default.CreditCard;"music"->Icons.Default.MusicNote;"cloud"->Icons.Default.Cloud;"code"->Icons.Default.Code;"send"->Icons.Default.Send;"tag"->Icons.Default.Tag else->Icons.Default.Android},null,tint=sc,modifier=Modifier.size(24.dp))
          Spacer(modifier=Modifier.width(12.dp))
          Column(modifier=Modifier.weight(1f)){ Text(i.name,fontSize=14.sp,fontWeight=FontWeight.SemiBold,color=White); Text(i.actions.take(2).joinToString(", "),fontSize=10.sp,color=Gray) }
          Column(horizontalAlignment=Alignment.End){ Text(i.status,fontSize=10.sp,color=sc,fontWeight=FontWeight.Medium); Text(i.lastSync.takeLast(8),fontSize=9.sp,color=Gray) }
        }
      }
    }
  }
}
@Composable fun EscalationsTab() {
  val escs = ApiService.fetchEscalations()
  Column{ escs.filter{it.priority=="P1"}.forEach{e->Card(modifier=Modifier.fillMaxWidth().padding(vertical=4.dp),colors=CardDefaults.cardColors(containerColor=Red.copy(alpha=0.15f)),shape=RoundedCornerShape(10.dp)){ Column(modifier=Modifier.padding(12.dp)){ Row{ Text(e.priority,fontSize=11.sp,fontWeight=FontWeight.Bold,color=Red); Spacer(modifier=Modifier.width(8.dp)); Text(e.agent,fontSize=12.sp,color=White,fontWeight=FontWeight.SemiBold); Spacer(modifier=Modifier.weight(1f)); Text("${e.hoursOpen}h",fontSize=11.sp,color=Red) }; Spacer(modifier=Modifier.height(4.dp)); Text(e.issue,fontSize=12.sp,color=White) } } }; escs.filter{it.priority!="P1"}.forEach{e->Card(modifier=Modifier.fillMaxWidth().padding(vertical=4.dp),colors=CardDefaults.cardColors(containerColor=DarkBlue),shape=RoundedCornerShape(10.dp)){ Column(modifier=Modifier.padding(12.dp)){ Row{ Text(e.priority,fontSize=11.sp,fontWeight=FontWeight.Bold,color=Amber); Spacer(modifier=Modifier.width(8.dp)); Text(e.agent,fontSize=12.sp,color=White,fontWeight=FontWeight.SemiBold); Spacer(modifier=Modifier.weight(1f)); Text(e.status,fontSize=10.sp,color=Gray) }; Spacer(modifier=Modifier.height(4.dp)); Text(e.issue,fontSize=12.sp,color=White) } } } }
}
@Composable fun Starting5Tab() {
  val s5 = ApiService.fetchStarting5()
  Column{ s5.forEach{ a->Card(modifier=Modifier.fillMaxWidth().padding(vertical=4.dp),colors=CardDefaults.cardColors(containerColor=DarkBlue),shape=RoundedCornerShape(12.dp)){ Column(modifier=Modifier.padding(14.dp)){ Row(verticalAlignment=Alignment.CenterVertically){ Box(modifier=Modifier.size(40.dp).background(Accent.copy(alpha=0.2f),CircleShape),contentAlignment=Alignment.Center){ Text(a.name.split(" ").map{it.first()}.joinToString(""),fontSize=14.sp,fontWeight=FontWeight.Bold,color=Accent) }; Spacer(modifier=Modifier.width(12.dp)); Column(modifier=Modifier.weight(1f)){ Text(a.name,fontSize=15.sp,fontWeight=FontWeight.Bold,color=White); Text(a.archetype,fontSize=11.sp,color=Accent) }; Text(a.status.uppercase(),fontSize=10.sp,color=Accent,fontWeight=FontWeight.Bold) } }; Spacer(modifier=Modifier.height(4.dp)); Text(a.specialty,fontSize=11.sp,color=Gray); Spacer(modifier=Modifier.height(4.dp)); Text("Focus: ${a.currentFocus}",fontSize=11.sp,color=White); Spacer(modifier=Modifier.height(4.dp)); Row{ a.metrics.entries.take(3).forEach{(k,v)->Column(modifier=Modifier.weight(1f)){ Text(k,fontSize=9.sp,color=Gray); Text("${v}",fontSize=13.sp,fontWeight=FontWeight.Bold,color=White) } } } } } }
}
@Composable fun ReportsTab() {
  val sprints = listOf("Sprint 24","Sprint 23","Sprint 22")
  Column { Section("Recent Sprints")
    sprints.forEach{s->Card(modifier=Modifier.fillMaxWidth().padding(vertical=4.dp),colors=CardDefaults.cardColors(containerColor=DarkBlue),shape=RoundedCornerShape(12.dp)){ Column(modifier=Modifier.padding(14.dp)){ Row{ Text(s,fontSize=14.sp,fontWeight=FontWeight.Bold,color=White,modifier=Modifier.weight(1f)); Text("23 tasks",fontSize=11.sp,color=Accent) }; Spacer(modifier=Modifier.height(4.dp)); Text("Velocity: 0.87  |  Blocker rate: 1  |  Avg cycle: 2.4 days",fontSize=10.sp,color=Gray) } } }
    Section("Workforce Report")
    Card(modifier=Modifier.fillMaxWidth(),colors=CardDefaults.cardColors(containerColor=DarkBlue),shape=RoundedCornerShape(12.dp)){ Column(modifier=Modifier.padding(14.dp)){ Text("This Cycle (Heartbeat 164)",fontSize=13.sp,fontWeight=FontWeight.Bold,color=Accent); Spacer(modifier=Modifier.height(8.dp))
      listOf("Pulse" to "Heartbeat 334 complete, 4 agents awakened","Chronicler" to "Activity logged","Sentinel" to "Security scan clean","Iris" to "IP scan complete","Avery" to "ESTCP 10 days to deadline").forEach{(ag,t)->Row(modifier=Modifier.padding(vertical=3.dp)){ Text("• ",color=Accent,fontSize=12.sp); Text(ag,fontSize=12.sp,fontWeight=FontWeight.SemiBold,color=White); Text(": ",fontSize=12.sp,color=Gray); Text(t,fontSize=11.sp,color=Gray) } } } }
}
@Composable fun ProjectsTab() {
  val projects = listOf("Irrig8" to "Precision agriculture OS — Launch ready","Valley Players Club" to "Sweepstakes gaming — Cash partner round","The Starting 5" to "AI co-founders SaaS — Feature spec v2","802 Morton Deal" to "Real estate arbitrage — Due diligence","Rain v2" to "Arbitrage intelligence — POC complete","AgentOS v4" to "AI workforce OS — Full architecture")
  Column { Section("Active Projects")
    projects.forEach{(n,d)->Card(modifier=Modifier.fillMaxWidth().padding(vertical=4.dp),colors=CardDefaults.cardColors(containerColor=DarkBlue),shape=RoundedCornerShape(12.dp)){ Column(modifier=Modifier.padding(14.dp)){ Text(n,fontSize=15.sp,fontWeight=FontWeight.Bold,color=White); Spacer(modifier=Modifier.height(4.dp)); Text(d,fontSize=12.sp,color=Gray) } } }
}
@Composable fun SettingsTab() {
  Column { Section("Notifications")
    listOf("P0 Escalations" to true,"P1 Escalations" to true,"Daily Digest" to false,"Weekly Report" to true,"Agent Standups" to false).forEach{(label,checked)->Row(modifier=Modifier.fillMaxWidth().padding(vertical=6.dp),verticalAlignment=Alignment.CenterVertically){ Text(label,fontSize=14.sp,color=White,modifier=Modifier.weight(1f)); Switch(checked=checked,onCheckedChange={},colors=SwitchDefaults.colors(checkedThumbColor=Accent,checkedTrackColor=Accent.copy(alpha=0.5f))) } }
    Section("Display")
    listOf("Agent IDs" to true,"Department Colors" to true,"Health Scores" to true,"Protocol Counts" to false).forEach{(label,checked)->Row(modifier=Modifier.fillMaxWidth().padding(vertical=6.dp),verticalAlignment=Alignment.CenterVertically){ Text(label,fontSize=14.sp,color=White,modifier=Modifier.weight(1f)); Switch(checked=checked,onCheckedChange={},colors=SwitchDefaults.colors(checkedThumbColor=Accent,checkedTrackColor=Accent.copy(alpha=0.5f))) } }
    Section("About")
    Card(modifier=Modifier.fillMaxWidth(),colors=CardDefaults.cardColors(containerColor=DarkBlue),shape=RoundedCornerShape(12.dp)){ Column(modifier=Modifier.padding(14.dp)){ Text("AgentOS",fontSize=16.sp,fontWeight=FontWeight.Bold,color=Accent); Text("Bxthre3 Digital Workforce Operating System",fontSize=12.sp,color=Gray); Spacer(modifier=Modifier.height(4.dp)); Text("25 agents  |  14 departments  |  13 integrations",fontSize=11.sp,color=Gray) } }
}
