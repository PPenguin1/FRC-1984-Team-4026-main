package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.ArmConstants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

public class ArmSubsystem extends SubsystemBase
{
    private TalonFX armKrakenMotorLower, armKrakenMotorUpper;

    private double targetPosition;

    private double minArmAngle;

    public ArmSubsystem(int armKrakenMotorLowerPort, int armKrakenMotorUpperPort)
    {
        armKrakenMotorLower = new TalonFX(armKrakenMotorLowerPort);
        armKrakenMotorUpper = new TalonFX(armKrakenMotorUpperPort);

        TalonFXConfiguration mainMotorconfigs = new TalonFXConfiguration();

        armKrakenMotorLower.getConfigurator().apply(mainMotorconfigs);
        armKrakenMotorUpper.getConfigurator().apply(mainMotorconfigs);

        minArmAngle = 1/360.0;
        targetPosition = 1/360.0;
    }

    public void setArmPositionLower(double position)
    {
        targetPosition = position;
        System.out.println(position);
        
        this.targetPosition = Math.max(Math.min(targetPosition, ArmConstants.LOWER_ARNGLE_MIN_POSTION), position );

    }

    public void setArmPositionUpper(double position)
    {
        targetPosition = position;
        System.out.println(position);
        
        this.targetPosition = Math.max(Math.min(targetPosition, ArmConstants.UPPER_ARNGLE_MIN_POSTION), position );

    }

    
}