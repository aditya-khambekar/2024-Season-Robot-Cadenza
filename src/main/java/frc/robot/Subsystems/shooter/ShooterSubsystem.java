package frc.robot.Subsystems.shooter;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IDs;
import java.util.Objects;

public class ShooterSubsystem extends SubsystemBase {
  private static volatile ShooterSubsystem instance;

  private TalonFX shooterLeft = new TalonFX(IDs.SHOOTER_SHOOTER_LEFT_MOTOR);
  private TalonFX shooterRight = new TalonFX(IDs.SHOOTER_SHOOTER_RIGHT_MOTOR);

  public static synchronized ShooterSubsystem getInstance() {
    return instance = Objects.requireNonNullElseGet(instance, ShooterSubsystem::new);
  }

  public void setShooterSpeed(double speed) {
    shooterLeft.set(speed);
    shooterRight.set(speed);
  }

  public void stop() {
    shooterLeft.set(0);
    shooterRight.set(0);
  }

  public TalonFX getShooterLeft() {
    return shooterLeft;
  }

  public void setShooterLeft(TalonFX shooterLeft) {
    this.shooterLeft = shooterLeft;
  }

  public TalonFX getShooterRight() {
    return shooterRight;
  }

  public void setShooterRight(TalonFX shooterRight) {
    this.shooterRight = shooterRight;
  }

  enum ShooterState {
    IDLE,
    SPINUP,
    READY,
  }
}
