package frc.robot.Subsystems.climber;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IDs;
import java.util.Objects;

public class ClimberSubsystem extends SubsystemBase {
  private static volatile ClimberSubsystem instance;

  TalonFX leftClimber = new TalonFX(IDs.CLIMBER_LEFT);
  TalonFX rightClimber = new TalonFX(IDs.CLIMBER_RIGHT);

  public static synchronized ClimberSubsystem getInstance() {
    return instance = Objects.requireNonNullElseGet(instance, ClimberSubsystem::new);
  }

  public void setLeftClimber(double speed) {
    leftClimber.set(speed);
  }

  public void setRightClimber(double speed) {
    rightClimber.set(speed);
  }

  public void stopAll() {
    setLeftClimber(0);
    setRightClimber(0);
  }

  public Command synchronizedClimberMotion(double speed) {
    return startEnd(
        () -> {
          setLeftClimber(speed);
          setRightClimber(speed);
        },
        this::stopAll);
  }

  public Command unsynchronizedClimberMotion(double speedLeft, double speedRight) {
    return startEnd(
        () -> {
          setLeftClimber(speedLeft);
          setRightClimber(speedRight);
        },
        this::stopAll);
  }

  public TalonFX getLeftClimber() {
    return leftClimber;
  }

  public void setLeftClimber(TalonFX leftClimber) {
    this.leftClimber = leftClimber;
  }

  public TalonFX getRightClimber() {
    return rightClimber;
  }

  public void setRightClimber(TalonFX rightClimber) {
    this.rightClimber = rightClimber;
  }
}
