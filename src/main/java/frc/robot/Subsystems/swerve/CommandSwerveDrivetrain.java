package frc.robot.Subsystems.swerve;

import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrain;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.helper.Limelight.LimelightHelpers;
import java.util.Arrays;

public class CommandSwerveDrivetrain extends SwerveDrivetrain {
    public SwerveDriveKinematics m_kinematics;
    double baseRadius;

    public CommandSwerveDrivetrain(SwerveDrivetrainConstants driveTrainConstants, SwerveModuleConstants... modules) {
        super(driveTrainConstants, modules);
        seedFieldRelative(new Pose2d());

        this.baseRadius =
                Arrays.stream(modules)
                        .map(module -> Math.hypot(module.LocationX, module.LocationY))
                        .reduce(0.0, Double::max);
    }

    public void update() {
        //this.m_kinematics = super.m_kinematics;
        LimelightHelpers.PoseEstimate poseEstimate =
                LimelightHelpers.getBotPoseEstimate_wpiBlue("limelight");
        if (poseEstimate != null && !poseEstimate.pose.getTranslation().equals(new Translation2d(0, 0))) {
            addVisionMeasurement(poseEstimate.pose, Timer.getFPGATimestamp());
        }
    }
}