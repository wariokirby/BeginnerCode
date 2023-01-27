// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  private MotorControllerGroup leftDrive;
  private MotorControllerGroup rightDrive;
  private DifferentialDrive robotDrive;

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    var leftFront = new CANSparkMax(1, MotorType.kBrushless);
    var leftBack = new CANSparkMax(2, MotorType.kBrushless);
    leftDrive = new MotorControllerGroup(leftFront, leftBack);

    var rightFront = new CANSparkMax(3, MotorType.kBrushless);
    var rightBack = new CANSparkMax(4, MotorType.kBrushless);
    rightDrive = new MotorControllerGroup(rightFront, rightBack);

    robotDrive = new DifferentialDrive(leftDrive, rightDrive);

  }

  public void driveRobot(double throttle , double steer){
    robotDrive.arcadeDrive(throttle, steer);
  }

  public void stop(){
    leftDrive.stopMotor();
    rightDrive.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
