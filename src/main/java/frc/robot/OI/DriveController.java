package frc.robot.OI;

import edu.wpi.first.wpilibj2.command.button.Trigger;

import java.util.function.DoubleSupplier;

public class DriveController {
  static Trigger Shooter = oi.Buttons.A_BUTTON;
  static Trigger ClimberUp = oi.Buttons.DPAD_UP;
  static Trigger ClimberDown = oi.Buttons.DPAD_DOWN;
  static Trigger ClimberLeft = oi.Buttons.DPAD_LEFT;
  static Trigger ClimberRight = oi.Buttons.DPAD_RIGHT;
  static Trigger Intake = oi.Buttons.Y_BUTTON;
  static Trigger Outtake = oi.Buttons.X_BUTTON;
  public static DoubleSupplier ForwardAxis = oi.Axis::getLeftStickX;
  public static DoubleSupplier StrafeAxis = oi.Axis::getLeftStickY;
  public static DoubleSupplier RotationAxis = oi.Axis::getRightStickX;
}
