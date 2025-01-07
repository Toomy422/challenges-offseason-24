package frc.robot.subsystems.intake.pivot;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.SingleJointedArmSim;
import frc.robot.Constants.IntakeConstants;

public class PivotIOSim implements PivotIO {
  // For instructions on how to implement this class, refer to the README.md file

  private SingleJointedArmSim m_sim;
  // define more members here as necessary
  private double voltage;

  public PivotIOSim() {
    // TODO: Implement this constructor
    m_sim =
        new SingleJointedArmSim(
            DCMotor.getNEO(1),
            IntakeConstants.kPivotGearing,
            IntakeConstants.kPivotJKgMetersSquared,
            IntakeConstants.kPivotLength,
            IntakeConstants.kPivotMinAngle,
            IntakeConstants.kPivotMaxAngle,
            false,
            Units.degreesToRadians(120));
  }

  @Override
  public void updateInputs(PivotInputs inputs) {
    m_sim.update(0.02);

    inputs.voltage = getVoltage();
    inputs.velocityRadPerSec = getVelocityRadPerSec();
    inputs.angleRad = getAngle().getRadians();
  }

  @Override
  public void setVoltage(double voltage) {
    // TODO: Implement this method
    m_sim.setInputVoltage(voltage);
    this.voltage = voltage;
  }

  @Override
  public double getVoltage() {
    // TODO: Implement this method
    return voltage;
  }

  @Override
  public double getVelocityRadPerSec() {
    // TODO: Implement this method
    return m_sim.getVelocityRadPerSec();
  }

  @Override
  public Rotation2d getAngle() {
    // TODO: Implement this method
    return new Rotation2d(m_sim.getAngleRads());
  }
}
