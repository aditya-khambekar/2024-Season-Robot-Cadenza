package frc.robot.OI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.DriveConstants;

public class oi {
    static XboxController controller = new XboxController(0);

    static class Buttons{
        static Trigger A_BUTTON = new Trigger(controller::getAButton);
        static Trigger B_BUTTON = new Trigger(controller::getBButton);
        static Trigger X_BUTTON = new Trigger(controller::getXButton);
        static Trigger Y_BUTTON = new Trigger(controller::getYButton);
        static Trigger LEFT_BUMPER = new Trigger(controller::getLeftBumper);
        static Trigger RIGHT_BUMPER = new Trigger(controller::getRightBumper);
        static Trigger DPAD_UP = new Trigger(() -> controller.getPOV() == 0);
        static Trigger DPAD_DOWN = new Trigger(() -> controller.getPOV() == 180);
        static Trigger DPAD_LEFT = new Trigger(() -> controller.getPOV() == 270);
        static Trigger DPAD_RIGHT = new Trigger(() -> controller.getPOV() == 90);
        static Trigger LEFT_TRIGGER = new Trigger(() -> controller.getLeftTriggerAxis() > DriveConstants.TRIGGER_THRESHOLD);
        static Trigger RIGHT_TRIGGER = new Trigger(() -> controller.getRightTriggerAxis() > DriveConstants.TRIGGER_THRESHOLD);
    }

    static class Axis{
        static double getLeftStickX(){
            return controller.getRawAxis(0)-DriveConstants.DEADZONE_VALUE;
        }

        static double getLeftStickY(){
            return controller.getRawAxis(1)-DriveConstants.DEADZONE_VALUE;
        }

        static double getRightStickX(){
            return controller.getRawAxis(2)-DriveConstants.DEADZONE_VALUE;
        }

        static double getRightStickY(){
            return controller.getRawAxis(3)-DriveConstants.DEADZONE_VALUE;
        }
    }
}
