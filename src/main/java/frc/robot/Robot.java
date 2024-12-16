// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.*;
import org.littletonrobotics.junction.LoggedRobot;

public class Robot extends LoggedRobot {
  private static boolean isAuton = false;
  private Command autonomousCommand;

  private RobotContainer robotContainer;

  public static boolean isInAuton() {
    return isAuton;
  }

  @Override
  public void robotInit() {
    robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledPeriodic() {

    var alliance = DriverStation.getAlliance();
  }

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousExit() {
    isAuton = false;
    if (autonomousCommand != null) {
      CommandScheduler.getInstance().removeComposedCommand(autonomousCommand);
    }
  }

  @Override
  public void teleopInit() {
    isAuton = false;
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }
}
