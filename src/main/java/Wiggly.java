import java.util.Scanner;

public class Wiggly {
    public static void main(String[] args) {
        String logo = """
                #%@@@@@@@@@@@#####**********##@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%@%#**@@@@@@@@@@@@@@@@@@@@@
                ##%@@@@@@@@@%**####**********#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%##**%##@@@@@@@@@@@@@@@@@@@@@
                ###%@@@@@@@@##***##***********%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#**#%@@%#%@@@@@@@@@@@@@@@@@@@@@
                ####@@@@@@@@##@****##*********#@@@@@@%#**++*#%@@@@@@@@@@@@@@@@@@%#***#%@@@@@##@@@@@@@@@@@@@@@@@@@@@@
                ####%@@@@@@@##@@*****##*******#%@@@%**********#@@@@@@@@@@@@@@@%***#%@@@@@@@##@@@@@@@@@@@@@@@@@@@@@@@
                #####%@@@@@@%*%@@%*****##******%@@%********###*@@@@@@@@@@@@@#***%@@@@@@@@@##%@@@@@@@@@@@@@@@@@@@@@@@
                ######@@@@@@@**@@@@#******#****#@@******#*+**#%@@@@@@@@@@@@***%@@@@@@@@@%*#%@@@@@@@@@@@@@@@@@@@@%%@@
                #######@@@@@@%*#@@@@@#******##*#@@*******######%@@@@@@@@@@#*#@@@@@@@@@@%*#%@@@@@@@@@@@@@@@@@@@@%%%@@
                ##*####%@@@@@@#**@@@@@@%#*****##%@************###%%%@@@@@@+*@@@@@@@@@@#*#%@@@@@@@@@@@@@@@@@@@@%%%%@@
                ##***###%@@@@@@%**#@@@@@@@%#***#%@#***********##*#****##%%+%%@%@@@@%#*###%@@@@@@@@@@@@@@@@@@%%##%@@@
                ##****###@@@@@@@@#**#@@@@@@@@#*+*@%***********#************+**%##*###%#*#%@@@@@@@@@@@@@@@@@%###%@@@@
                **#*+**###@@@@@@@@@%**#%@@@@@@@#+**##***********+++******+***#%%%#**##**%@@@@@@@@@@@@@@@@@%###%@@@%%
                *****+**##%@@@@@@@@@@@##**#%%@%#***+*###********************#*%@#+*###*#%@@@@@@@@@@@@@@@@%#**#%@%%%@
                ******+**##@@@@@@@@@@@%#####**********######*****###%%%%#%#*#**%#**##**#%@@@@@@@@@@@@@@@%***#%@%%%@@
                ******++**#%@@@@@@@@@@@#####********####*#%####*#*####%%%%%*#**##%###*#%@@@@@@@@@@@@@@@%***#%%%#%%@@
                *******++**#@@@@@@@@@@@%##%**##########**%*****%*##******#*+%***##@#**%@@@@@@@@@@@@@@@%***#%%%#%%@@@
                #******+++*##@@@@@@@@@@@####%##########**@*****#%######%#**##+**###%*#%@@@@@@@@@@@@@@%#***%%%#%%@@@@
                %#***+**++**#%@@@@@@@@@@%###%####%%%%%#*#%++++++*%%%%%%%#%#*++**###%#%@@@@@@@@@@@@@@%#***%%###@@@@@@
                @@#***+**++**#@@@@@@@@@@@#####%###%%%####+++####++*#####*+++*+***###@@@@@@@@@@@@@@@%#***%%#*%@@@@@@@
                @@@#***+*+++**#@@@@@@@@@@%#%****######*++++#%%%%%#+++++++++*#+***###%@@@@@@@@@@@@@@#***#%#*%@@@@@@@@
                @@@@%***+++++*#%@@@@@@@@@@%%***+++++++++++++%#****%++++++++#++***####%@@@@@@@@@@@@##**#%#*#@@@@@@@@@
                @@@@@%***++++**#@@@@@@@@@@@#***+++++#+++++++##****%*++++++#*++**####%#@@@@@@@@@@@%##*###*#@@@@@@@@@@
                @@@@@@%****+++**%@@@@@@@@@%****++++%*++++++++*#####+++++++%++***####%#@@@@@@@@@@%########%@@@@@@@@@@
                @@@@@@@@#****+**#@@@@@@@@@*****+++##+++++++++++++++++++++*%++***###%##@@@@@@@@@%%%#####%@@@@@@@@@@@@
                @@@@@@@@@#****+**#@@@@@@@@*****++*%+***++++++++++++++++++*%++***##%%#*@@@@@@@@@%@@####%@@@@@@@@@@@@@
                %@@@@@@@@%#******#%##%%%%@%****+*%@%%%@@%%###%%######%%@@@@#+***#@@@@@%@%########%%#%%@@@@@@@@@@@@@@
                ##@@@@@@@@%##***%%##@%%%%@@%#**#@@@@%%%@@@##########@@%@%@@@@@@@@@@%@@%@@@#####%##%%@@@@@@@@@@@@@@@@
                ###%@@@@@@@%###%%###@@@@@@@@@@@@@@@@%%@@@%##########@@@%@@@@@@@@@@@%%%%@@%####%###@@@@@@@@@@@@@@@@@@
                """;
        System.out.println(
                """
                ____________________________________
                Hello! I'm Wiggly
                What can I do for you?
                ____________________________________
                """);

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        TaskList taskList = new TaskList();
        String[] parts = in.split(" ", 2);
        String command = parts[0];

        while (!command.equals("bye")) {

            switch (command) {
                case "list" -> System.out.println(taskList);
                case "mark" -> {

                    try {
                        int value = Integer.parseInt(parts[1]);
                        if (value > taskList.getSize() || value <= 0) {
                            System.out.println(
                                    """
                                    ____________________________________
                                    There's no such task number!
                                    ____________________________________
                                    """
                            );
                        } else {
                            System.out.println(taskList.markDone(value));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(
                                """
                                ____________________________________
                                Oops, invalid number format detected
                                ____________________________________
                                """
                        );
                    }
                }
                case "unmark" -> {

                    try {
                        int value = Integer.parseInt(parts[1]);
                        if (value > taskList.getSize() || value <= 0) {
                            System.out.println(
                                    """
                                    ____________________________________
                                    There's no such task number!
                                    ____________________________________
                                    """
                            );
                        } else {
                            System.out.println(taskList.markUndone(value));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(
                                """
                                ____________________________________
                                Oops, invalid number format detected
                                ____________________________________
                                """
                        );
                    }
                }
                case "todo" -> {
                    try {
                        String taskDescription = parts[1];
                        System.out.println(taskList.addTask(new ToDo(taskDescription)));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(
                                """
                                ____________________________________
                                Oops, missing todo description
                                ____________________________________
                                """
                        );
                    }

                }
                case "deadline" -> {
                    try {
                        parts = parts[1].split(" /by ", 2);
                        String taskDescription = parts[0];
                        String by = parts[1];
                        System.out.println(taskList.addTask(new Deadline(taskDescription, by)));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(
                                """
                                ____________________________________
                                Oops, missing deadline description or by
                                ____________________________________
                                """
                        );
                    }
                }
                case "event" -> {
                    try {
                        parts = parts[1].split(" /from | /to ", 3);
                        String taskDescription = parts[0];
                        String from = parts[1];
                        String to = parts[2];
                        System.out.println(taskList.addTask(new Event(taskDescription, from, to)));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println(
                                """
                                ____________________________________
                                Oops, missing event description, from or to
                                ____________________________________
                                """
                        );
                    }
                }
                case "delete" -> {

                    try {
                        int value = Integer.parseInt(parts[1]);
                        if (value > taskList.getSize() || value <= 0) {
                            System.out.println(
                                    """
                                    ____________________________________
                                    There's no such task number!
                                    ____________________________________
                                    """
                            );
                        } else {
                            System.out.println(taskList.deleteTask(value));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(
                                """
                                ____________________________________
                                Oops, invalid number format detected
                                ____________________________________
                                """
                        );
                    }
                }
                default -> System.out.println(
                        """
                        ____________________________________
                        Sorry!! I don't know this command :(
                        ____________________________________
                        """
                );
            }

            in = sc.nextLine();
            parts = in.split(" ", 2);
            command = parts[0];
        }

        System.out.println(
                """
                ____________________________________
                Bye. Hope to see you again soon!
                ____________________________________
                """
        );

    }
}
