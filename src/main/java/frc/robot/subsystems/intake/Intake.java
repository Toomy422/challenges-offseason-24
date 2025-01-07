package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  // For instructions on how to implement this class, refer to the README.md file
  IntakeIO m_io;
  IntakeInputsAutoLogged inputsAutoLogged;

  public Intake(IntakeIO io) {
    // TODO: Implement the constructor
    m_io = io;
    inputsAutoLogged = new IntakeInputsAutoLogged();
  }

  @Override
  public void periodic() {
    // TODO: Implement this method
    m_io.updateInputs(inputsAutoLogged);
  }

  public void setRollerVoltage(double voltage) {
    m_io.setRollerVoltage(voltage);
    ;
  }

  public Command setVoltageCommand(double voltage) {
    // TODO: Implement this method
    return Commands.runOnce(() -> setRollerVoltage(voltage), this);
  }

  public IntakeInputsAutoLogged getInputs() {
    // TODO: Implement this method
    return inputsAutoLogged;
  }
}
