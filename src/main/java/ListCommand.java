public class ListCommand extends Command {


	@Override
	public void execute(TaskList taskList, Ui ui, Storage storage) {
		String str = Ui.TASK_HEADER + "\n" +
				taskList.toString();
		ui.printWrappedString(str);
	}
}
