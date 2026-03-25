package com.bxthre3.agentos.data
data class Agent(val id:String,val name:String,val role:String,val dept:String,val status:String,val locked:Boolean,val lastSeen:String,val health:Float,val protocolWakeups:Int,val accomplishments:List<String>,val blockers:List<String>,val escalations:List<String>,val nextShift:String?)
data class Dept(val id:String,val name:String,val head:String,val agents:List<String>,val metrics:Map<String,Any>,val activeProjects:List<String>,val escalationCount:Int)
data class WorkItem(val id:String,val agent:String,val task:String,val priority:String,val status:String,val created:String,val blockers:List<String>)
data class Integration(val id:String,val name:String,val status:String,val lastSync:String,val icon:String,val actions:List<String>)
data class Escalation(val id:String,val agent:String,val issue:String,val priority:String,val hoursOpen:Int,val status:String)
data class Starting5(val name:String,val archetype:String,val specialty:String,val currentFocus:String,val metrics:Map<String,Any>,val status:String)
data class SprintReport(val id:String,val sprint:String,val completed:Int,val velocity:Float,val agentBreakdown:Map<String,Int>,val highlights:List<String>,val blockers:List<String>,val timestamp:String)
data class SystemHealth(val agentCount:Int,val activeAgents:Int,val idleAgents:Int,val blockedAgents:Int,val workQueueDepth:Int,val escalationCount:Int,val avgHealth:Float,val uptime:String,val diskUsage:Int,val knownIssues:List<String>)
