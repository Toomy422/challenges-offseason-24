package frc.robot.subsystems.arm;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.math.geometry.Rotation2d;

public class ArmIOKraken implements ArmIO {
  // For instructions on how to implement this class, refer to the README.md file
  private TalonFX m_motor;

  public ArmIOKraken(int port) {
    m_motor = new TalonFX(port);
  }

  @Override
  public void setVoltage(double voltage) {
    m_motor.setVoltage(voltage);
  }

  @Override
  public double getVoltage() {
    // TODO: Implement this method
    return m_motor.getMotorVoltage().getValueAsDouble();
  }

  @Override
  public double getVelocityRadiansPerSecond() {
    // TODO: Implement this method
    m_motor.getRotorVelocity().getValueAsDouble();
    return m_motor.getVelocity().getValueAsDouble() * (Math.PI * 2);
  }

  @Override
  public Rotation2d getPosition() {
    // TODO: Implement this method
    return new Rotation2d(m_motor.getPosition().getValue() * (2 * Math.PI));
  }

  @Override
  public Object getMotor() {
    // DO NOT MODIFY THIS METHOD
    return m_motor;
  }
}
