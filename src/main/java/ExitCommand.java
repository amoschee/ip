public class ExitCommand extends Command {

	public ExitCommand() {
	}

	@Override
	public void execute(TaskList taskList, Ui ui, Storage storage) {
		ui.printExit();
	}

	@Override
	public boolean isExit() {
		return true;
	}
}