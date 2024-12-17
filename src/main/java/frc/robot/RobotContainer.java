// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Subsystems.swerve.SwerveDriveSubsystem;
import frc.robot.Subsystems.swerve.TunerConstants;

import static frc.robot.OI.DriveController.Aimer;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class RobotContainer {

  SwerveDriveSubsystem driveSubsystem = TunerConstants.DriveTrain;

  public RobotContainer() {
    configureBindings();
  }

  private void nameCommands() {}

  private void configureBindings() {
    driveSubsystem.setDefaultCommand(driveSubsystem.fieldCentricDrive());
    Aimer.whileTrue(driveSubsystem.fieldCentricDrive());
  }
}
