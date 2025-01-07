package frc.robot.subsystems.wrist;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wrist extends SubsystemBase {
  // For instructions on how to implement this class, refer to the README.md file
  WristIO m_io;
  PIDController m_controller;
  WristInputsAutoLogged inputs;

  public Wrist(WristIO io, PIDController controller) {
    // TODO: Implement the constructor
    m_io = io;
    m_controller = controller;
    inputs = new WristInputsAutoLogged();
  }

  @Override
  public void periodic() {
    // TODO: Implement this method
    m_io.updateInputs(inputs);
    m_io.setVoltage(
        m_controller.calculate(m_io.getAngle().getDegrees(), m_controller.getSetpoint()));
  }

  public void setDesiredAngle(Rotation2d angle) {
    // TODO: Implement this method
    m_controller.setSetpoint(angle.getDegrees());
  }

  public Command setDesiredAngleCommand(Rotation2d angle) {
    // TODO: Implement this method
    setDesiredAngle(angle);
    return Commands.run(
        (Runnable)
            (() ->
                m_io.setVoltage(
                    m_controller.calculate(angle.getDegrees(), m_controller.getSetpoint()))));
  }

  public boolean withinTolerance() {
    // TODO: Implement this method
    return m_controller.getPositionError() <= 3;
  }

  public WristInputsAutoLogged getInputs() {
    // TODO: Implement this method
    return inputs;
  }
}
