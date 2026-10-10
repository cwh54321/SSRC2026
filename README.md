# SSRC2026 (FRC Team 12)

2026 FRC 킷봇 로봇 코드 (WPILib 2026, Java).

## 파일

- `src/main/java/frc/robot/Robot.java` — 드라이브트레인 + 인테이크 + 런처 조작 코드

이 저장소에는 `Robot.java`만 들어 있어. 빌드하려면 팀 번호 12로 만든 WPILib 2026 프로젝트에 이 파일을 덮어쓰고, **REVLib** 벤더 라이브러리가 설치돼 있어야 해 (`com.revrobotics.spark.SparkMax` 사용).

## CAN ID

| 부품 | CAN ID | 변수 |
|---|---|---|
| 왼쪽 드라이브 1 | 1 | `leftMotor1` |
| 왼쪽 드라이브 2 | 2 | `leftMotor2` |
| 오른쪽 드라이브 1 | 3 | `rightMotor1` |
| 오른쪽 드라이브 2 | 4 | `rightMotor2` |
| 인테이크 | 5 | `intakeMotor` |
| 런처(슈터) | 6 | `launcherMotor` |

모터는 전부 브러시 모터(`MotorType.kBrushed`), 컨트롤러는 SPARK MAX야.

## 조작 (Logitech Gamepad F310)

| 입력 | 기능 |
|---|---|
| 축 0 / 축 1 | 주행 (축 0 = 전진·후진, 축 1 = 좌·우 회전) |
| 버튼 1번 | 인테이크 정방향 (누르는 동안) |
| 버튼 3번 | 인테이크 역방향 (누르는 동안) |
| 버튼 2번 | 런처 작동 (누르는 동안) |

버튼 번호는 컨트롤러 뒤의 X / D 모드에 따라 다를 수 있으니 Driver Station의 USB 탭에서 확인해.

## 배포

1. 노트북을 로봇 와이파이(`FRC-12`)에 연결
2. VS Code에서 `Ctrl+Shift+P` → **WPILib: Deploy Robot Code**
3. Driver Station에서 Communications / Robot Code / Joysticks가 초록불인지 확인 후 Enable

처음 테스트할 때는 로봇을 바닥에서 들어 올린 상태에서 방향부터 확인해.
