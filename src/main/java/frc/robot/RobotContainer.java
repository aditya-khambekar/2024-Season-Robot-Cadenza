// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.oi.OI;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class RobotContainer {
  public static OI oi;

  public RobotContainer() {
    oi = new OI();
    configureBindings();
  }

  private void nameCommands() {

  }

  private void configureBindings() {

  }


}
