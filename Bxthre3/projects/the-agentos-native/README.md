# AgentOS Native

Native Android application for AgentOS — autonomous AI agent orchestration platform.

## Build

```bash
cd android
./gradlew assembleDebug
```

APK output: `android/app/build/outputs/apk/debug/app-debug.apk`

## Tech Stack

- **Language**: Kotlin 2.0
- **UI**: Jetpack Compose (Material 3)
- **Networking**: Ktor
- **Architecture**: MVVM with ViewModel + StateFlow
- **DI**: Hilt (if added)

## API

Connects to `https://brodiblanco.zo.space/api/agentos/android`

| Endpoint | Method | Description |
|---|---|---|
| `/agents` | GET | List all agents |
| `/agents/{id}` | GET | Get agent details |
| `/tasks` | GET | List all tasks |
| `/inbox` | GET | Get inbox messages |

## Screens

- **Agents** — Browse and manage AI agents
- **Inbox** — Unread messages across all agents
- **War Room** — Grants pipeline and active priorities
- **Grants** — Grant opportunities and tracking
- **Starting 5** — Top 5 active agents
- **Integrations** — Connected external services
- **Departments** — Organizational structure
