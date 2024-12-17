package frc.robot.Subsystems.swerve;

import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrain;
import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.mechanisms.swerve.SwerveModuleConstants;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants.FieldConstants;
import frc.robot.helper.Limelight.LimelightHelpers;
import java.util.Arrays;

public class CommandSwerveDrivetrain extends SwerveDrivetrain {
    public SwerveDriveKinematics m_kinematics;
    
    public CommandSwerveDrivetrain(SwerveDrivetrainConstants driveTrainConstants, SwerveModuleConstants... modules) {
        super(driveTrainConstants, modules);
        seedFieldRelative(FieldConstants.kLeftBlueSpeakerPose.toPose2d());
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