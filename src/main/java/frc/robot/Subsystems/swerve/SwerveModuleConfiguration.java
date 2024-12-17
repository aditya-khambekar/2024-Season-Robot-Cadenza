package frc.robot.Subsystems.swerve;

public record SwerveModuleConfiguration(int driveMotorID, int rotatorMotorID, int encoderID, double rotationOffset,
                                        double rotatorPIDkPMultiplier) {
    public SwerveModuleConfiguration(int driveMotorID, int rotatorMotorID, int encoderID, double rotationOffset) {
        this(driveMotorID, rotatorMotorID, encoderID, rotationOffset, 1);
    }
}