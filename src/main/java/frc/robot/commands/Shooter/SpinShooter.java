package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Leds.Leds;
import frc.robot.subsystems.Shooter.Shooter;

public class SpinShooter extends Command {

  private final Shooter shooter;
  private final Leds leds;
  private final Timer timer = new Timer();

  public SpinShooter(Shooter shooter, Leds leds) {
    this.shooter = shooter;
    this.leds = leds;
    addRequirements(shooter, leds);
  }

  @Override
  public void initialize() {
    this.timer.reset();
    this.timer.start();
  }

  @Override
  public void execute() {
    this.shooter.shootSpeaker();
    this.leds.blinkLeds("#0000ff");
  }

  @Override
  public void end(boolean interrupted) {
    this.shooter.stop();
    this.timer.stop();
  }

  @Override
  public boolean isFinished() {
    return (this.timer.get() > 6.0);
  }
}