// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  public Robot() {
  }

  // 드라이브트레인 모터
  private SparkMax leftMotor1 = new SparkMax(1, MotorType.kBrushed);
  private SparkMax leftMotor2 = new SparkMax(2, MotorType.kBrushed);
  private SparkMax rightMotor1 = new SparkMax(3, MotorType.kBrushed);
  private SparkMax rightMotor2 = new SparkMax(4, MotorType.kBrushed);

  // Fuel Mechanism (킷봇 공식 구조: CIM 모터 2개, SparkMax로 제어)
  private SparkMax intakeMotor = new SparkMax(5, MotorType.kBrushed);   // 인테이크 샤프트 전체 구동
  private SparkMax launcherMotor = new SparkMax(6, MotorType.kBrushed); // 런처(슈터) 샤프트 구동

  private Joystick joystick1 = new Joystick(0);

  private double leftY = 0;
  private double leftX = 0;

  private double speed = 0;
  private double turn = 0;
  private double leftPower = 0;
  private double rightPower = 0;

  private final double INTAKE_SPEED = 0.6;
  private final double LAUNCHER_SPEED = 0.8;

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {

    leftY = joystick1.getRawAxis(0);
    leftX = joystick1.getRawAxis(1);

    speed = leftY * -0.15;
    turn = leftX * 0.15;

    leftPower = speed + turn;
    rightPower = speed - turn;

    leftMotor1.set(-leftPower);
    leftMotor2.set(-leftPower);
    rightMotor1.set(rightPower);
    rightMotor2.set(rightPower);

    // ---- 인테이크: 버튼 1번 정방향, 버튼 3번 역방향 ----
    if (joystick1.getRawButton(1)) {
      intakeMotor.set(INTAKE_SPEED);
    } else if (joystick1.getRawButton(3)) {
      intakeMotor.set(-INTAKE_SPEED);
    } else {
      intakeMotor.set(0);
    }

    // ---- 런처(슈터): 버튼 2번, 누르는 동안만 작동 ----
    if (joystick1.getRawButton(2)) {
      launcherMotor.set(LAUNCHER_SPEED);
    } else {
      launcherMotor.set(0);
    }
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
