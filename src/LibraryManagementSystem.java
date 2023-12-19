import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

// Part 1: Library Class
class Library{
    private final ArrayList<Item> inventory;

    // Constructor
    public Library(){
        inventory = new ArrayList<>();
    }


    // Adds an item to the library's inventory
    public void addItem(Item item){
        inventory.add(item);
    }

    // Removes an item from the library's inventory by title
    public void removeItem(String title){
        for (Item item : inventory) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                inventory.remove(item);
                System.out.println("Item removed successfully");
                break;
            }
        }
    }

    // List all available items in the library's inventory
    public void listAvailableItems(){
        System.out.println("Available Items:");
        for (Item item : inventory){
            if (!item.isCheckedOut()) {
                System.out.println(item.getDetails());
            }
        }
    }

    // List all checked-out items in the library's inventory.
    public void listAllCheckedOutItems() {
        boolean itemsCheckedOut = false;

        System.out.println("Checked-Out Items:");
        for (Item item : inventory) {
            if (item.isCheckedOut()) {
                System.out.println(item.getDetails());
                itemsCheckedOut = true;
            }
        }

        if (!itemsCheckedOut) {
            System.out.println("No item checked out by any member currently.");
        }
    }

    // Search for Items by Title
    public Item searchItemsByTitle(String title) {
        for (Item item : inventory) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }
}





// Part 2: Item Hierarchy
class Item{
    private String title;
    private String year;
    private boolean checkedOut;
    private LocalDate dueDate;

    // Constructor
    public Item(String title, String year){
        this.title = title;
        this.year = year;
        this.checkedOut = false;
        this.dueDate = null;
    }

    // Getters and Setters
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getYear(){
        return year;
    }

    public void setYear(String year){
        this.year = year;
    }

    public boolean isCheckedOut(){
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut){
        this.checkedOut = checkedOut;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Prompts the library manager to input data for item
    public void input(){
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the title: ");
        setTitle(userInput.nextLine());

        System.out.print("Enter the year: ");
        setYear(userInput.nextLine());
    }

    // Prints all the item's data
    public void print(){
        System.out.println("Title: " + getTitle());
        System.out.println("Year: " + getYear());
    }

    // Returns a formatted string containing all the item's details
    public String getDetails(){
        String details = "Title: " + getTitle() + "\n";
        details += "Year: " + getYear() + "\n";
        return details;
    }
}





// Part 3: Book Function
class Book extends Item{
    private String author;
    private String ISBN;
    private String genre;
    private int numberOfPages;

    // Constructor
    public Book(String title, String author, String year, String ISBN, String genre, int numberOfPages){
        super(title, year);
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    // Getters and Setters
    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getISBN(){
        return ISBN;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public int getNumberOfPages(){
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages){
        this.numberOfPages = numberOfPages;
    }

    // Prompts the library manager to input data for the book
    @Override
    public void input(){
        super.input();
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the author of the book: ");
        setAuthor(userInput.nextLine());

        System.out.print("Enter the ISBN of the book: ");
        setISBN(userInput.nextLine());

        System.out.print("Enter the genre of the book: ");
        setGenre(userInput.nextLine());

        System.out.print("Enter the number of pages in the book: ");
        setNumberOfPages(userInput.nextInt());
        userInput.nextLine();
    }

    // Prints all the book's data
    @Override
    public void print(){
        super.print();
        System.out.println("Author: " + getAuthor());
        System.out.println("ISBN: " + getISBN());
        System.out.println("Genre: " + getGenre());
        System.out.println("Number of Pages: " + getNumberOfPages());
    }

    // Returns a formatted string containing all the book's details
    @Override
    public String getDetails(){
        String details = "BOOK" + "\n";
        details += super.getDetails();
        details += "Author: " + getAuthor() + "\n";
        details += "ISBN: " + getISBN() + "\n";
        details += "Genre: " + getGenre() + "\n";
        details += "Number of Pages: " + getNumberOfPages() + "\n";
        return details;
    }
}





// Part 4: DVD Function
class DVD extends Item{
    private String director;
    private String runtime;
    private String genre;

    // Constructor
    public DVD(String title, String director, String year, String runtime, String genre){
        super(title, year);
        this.director = director;
        this.runtime = runtime;
        this.genre = genre;
    }

    // Getters and Setters
    public String getDirector(){
        return director;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public String getRuntime(){
        return runtime;
    }

    public void setRuntime(String runtime){
        this.runtime = runtime;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    // Prompts the library manager to input data for the DVD
    @Override
    public void input(){
        super.input();
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the director of the DVD: ");
        setDirector(userInput.nextLine());

        System.out.print("Enter the runtime of the DVD: ");
        setRuntime(userInput.nextLine());

        System.out.print("Enter the genre of the DVD: ");
        setGenre(userInput.nextLine());
    }

    // Prints all the DVD's data
    @Override
    public void print(){
        super.print();
        System.out.println("Director: " + getDirector());
        System.out.println("Runtime: " + getRuntime());
        System.out.println("Genre: " + getGenre());
    }

    // Returns a formatted string containing all the DVD's details
    @Override
    public String getDetails(){
        String details = "DVD" + "\n";
        details += super.getDetails();
        details += "Director: " + getDirector() + "\n";
        details += "Runtime: " + getRuntime() + "\n";
        details += "Genre: " + getGenre() + "\n";
        return details;
    }
}





// Part 5: Magazine Function
class Magazine extends Item{
    private String publisher;
    private String issueNumber;
    private String topic;

    // Constructor
    public Magazine(String title, String publisher, String year, String issueNumber, String topic){
        super(title, year);
        this.publisher = publisher;
        this.issueNumber = issueNumber;
        this.topic = topic;
    }

    // Getters and Setters
    public String getPublisher(){
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public String getIssueNumber(){
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber){
        this.issueNumber = issueNumber;
    }

    public String getTopic(){
        return topic;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    // Prompts the library manager to input data for the magazine
    @Override
    public void input(){
        super.input();
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the publisher of the magazine: ");
        setPublisher(userInput.nextLine());

        System.out.print("Enter the issue number of the magazine: ");
        setIssueNumber(userInput.nextLine());

        System.out.print("Enter the topic of the magazine: ");
        setTopic(userInput.nextLine());
    }

    // Prints all the magazine's data
    @Override
    public void print(){
        super.print();
        System.out.println("Publisher: " + getPublisher());
        System.out.println("Issue Number: " + getIssueNumber());
        System.out.println("Topic: " + getTopic());
    }

    // Returns a formatted string containing all the magazine's details
    @Override
    public String getDetails(){
        String details = "MAGAZINE" + "\n";
        details += super.getDetails();
        details += "Publisher: " + getPublisher() + "\n";
        details += "Issue Number: " + getIssueNumber() + "\n";
        details += "Topic: " + getTopic() + "\n";
        return details;
    }
}





// Part 6: Library Member
class LibraryMember{
    private String memberId;
    private String name;
    private final Map<Item, LocalDate> checkedOutItems;
    private final List<Item> checkedOutHistory;
    private static final int MAX_CHECKOUT_ITEMS = 2;

    // Constructor
    public LibraryMember(String memberId, String name){
        this.memberId = memberId;
        this.name = name;
        this.checkedOutItems = new HashMap<>();
        this.checkedOutHistory = new ArrayList<>();
    }

    // Getters and Setters
    public String getMemberId(){
        return memberId;
    }

    public void setMemberId(String memberId){
        this.memberId = memberId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Map<Item, LocalDate> getCheckedOutItem(){
        return checkedOutItems;
    }

    // Allows a member to check out an item
    public void checkOutItem(Item item){
        if (item != null && !item.isCheckedOut()) {
            if (checkedOutItems.size() < MAX_CHECKOUT_ITEMS) {
                LocalDate currentDate = LocalDate.now();
                LocalDate dueDate = currentDate.plusDays(14); // Default due date is set to 14 days from the current date
                item.setDueDate(dueDate);

                checkedOutItems.put(item, item.getDueDate()); // Store the item and its due date
                checkedOutHistory.add(item); // Add the item to the checkout history
                item.setCheckedOut(true);

                System.out.println(getName() + " checked out: " + item.getTitle());
                System.out.println("Due date: " + item.getDueDate());
                System.out.println("Please return the item before the due date. A fine of RM 1.50 will be applied for each day overdue.\n");
                System.out.println("Item checked out successfully.");
            } else {
                System.out.println("You have reached the maximum number of checkouts (" + MAX_CHECKOUT_ITEMS + "). Please return an item before checking out a new one.");
            }
        } else {
            System.out.println("Item not found in the library inventory.");
        }
    }

    // Allows a member to return an item
    public void returnItem(Item item){
        if (item != null && item.isCheckedOut()) {
            checkedOutItems.remove(item);
            item.setCheckedOut(false);
            System.out.println(getName() + " returned: " + item.getTitle() + "\n");

            double fine = calculateFine(item);
            if (fine > 0) {
                System.out.println("Item returned after the due date. Fine applied: $" + fine);
            } else {
                System.out.println("Item returned successfully.");
            }
        } else {
            System.out.println("Item not found in the library inventory.");
        }
    }

    // Implementing a fine system for overdue items.
    public double calculateFine(Item item){
        if (item.getDueDate() != null) {
            LocalDate currentDate = LocalDate.now();
            LocalDate dueDate = item.getDueDate();

            // Calculate the difference in days
            long daysDifference = ChronoUnit.DAYS.between(dueDate, currentDate);

            // Apply a fine of RM 1.50 for each day overdue
            double fine = daysDifference * 1.5;

            // Ensure the fine is not negative
            return Math.max(0, fine);
        } else {
            // No due date set, no fine
            return 0;
        }
    }

    // Lists all items currently checked out by the member
    public void listCheckedOutItems(){
        if (checkedOutItems.isEmpty()) {
            System.out.println("No items currently checked out by the member.");
        } else {
            System.out.println("Checked-Out Items for " + getName() + ":");
            for (Map.Entry<Item, LocalDate> entry : checkedOutItems.entrySet()) {
                Item item = entry.getKey();
                LocalDate dueDate = entry.getValue();
                System.out.println(item.getDetails());
                System.out.println("Due date: " + dueDate);
                System.out.println();
            }
        }
    }

    // Lists the checkout history of the member
    public void listCheckedOutHistory(){
        if (checkedOutHistory.isEmpty()) {
            System.out.println("No checkout history for " + getName());
        } else {
            System.out.println("Checkout History for " + getName() + ":");
            for (Item item : checkedOutHistory) {
                System.out.println(item.getDetails());
                System.out.println();
            }
        }
    }
}





// Part 7: Execution
public class LibraryManagementSystem{
    private final Library library;

    private LibraryMember libraryMember;
    private Item item;
    private final Scanner userInput;
    private final Random random;
    private final Map<String, LibraryMember> memberMap;

    public LibraryManagementSystem(){
        userInput = new Scanner(System.in);
        library = new Library();

        // Add Items
        Book book = new Book("The Catcher in the Rye", "J.D. Salinger", "2018", "123-456-789", "Action", 150);
        DVD dvd = new DVD("Inception", "Christopher Nolan", "2020", "1:45:08", "Romance");
        Magazine magazine = new Magazine("National Geographic", "Brandon Ting", "2023", "#123", "Documentary");

        library.addItem(book);
        library.addItem(dvd);
        library.addItem(magazine);

        random = new Random();
        memberMap = new HashMap<>();
    }

    public void run(){
        System.out.println("Welcome to the Brandon's Library Management System!");

        int option;
        do {
            displayMenu();
            option = userInput.nextInt();
            userInput.nextLine();
            System.out.println("-----------------------------------");

            switch (option) {
                case 1:
                    registerMember();
                    break;
                case 2:
                    checkOutItem();
                    break;
                case 3:
                    returnItem();
                    break;
                case 4:
                    listAvailableItems();
                    break;
                case 5:
                    listCheckedOutItems();
                    break;
                case 6:
                    searchItemsByTitle();
                    break;
                case 7:
                    listCheckedOutHistory();
                    break;
                case 8:
                    adminLogin();
                    break;
                case 9:
                    System.out.println("Thank you for using the Brandon's Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again (1-7).");
                    break;
            }
        } while (option != 9);
    }

    private void displayMenu(){
        System.out.print("""
                -----------------------------------
                1. Register as a New Library Member
                2. Check Out an Item
                3. Return an Item
                4. List Available Items
                5. List Checked-Out Items
                6. Search for Items by Title
                7. History of Checked-Out Items
                8. Admin Login
                9. Exit
                -----------------------------------
                Enter your choice:""");
    }

    // 1. Register as a New Library Member
    private void registerMember(){
        System.out.print("Enter your name: ");
        String name = userInput.nextLine();
        String memberId = generateMemberId();

        // Check if a member with the entered name already exists
        if (isExistingMemberName(name)) {
            System.out.println("A member with the name '" + name + "' already exists. Please enter a different name.");
        } else {
            libraryMember = new LibraryMember(memberId, name);
            memberMap.put(memberId, libraryMember);

            System.out.println(name + ", you are now registered as a library member with ID: " + memberId);
        }
    }

    // Generate random but unique member ID
    private String generateMemberId() {
        String memberId;
        do {
            int randomId = random.nextInt(99998) + 1; // Generate a random id between 00000 and 99999
            memberId = String.format("%05d", randomId);
        } while (memberMap.containsKey(memberId)); // Check for uniqueness

        return memberId;
    }

    // Check if there is any member in the memberMap with the given name
    private boolean isExistingMemberName(String name) {
        return memberMap.values().stream().anyMatch(member -> member.getName().equalsIgnoreCase(name));
    }

    // 2. Check Out an Item
    private void checkOutItem(){
        System.out.print("Enter your member ID: ");
        String memberId = userInput.nextLine();
        libraryMember = memberMap.get(memberId);

        if (!memberMap.containsKey(memberId)) {
            System.out.println("Invalid member ID. Please try again.");
        } else {
            library.listAvailableItems();

            System.out.print("Enter the title of the item you want to check out: ");
            String title = userInput.nextLine();
            System.out.println("-----------------------------------");

            // Search for the item in the library inventory
            item = library.searchItemsByTitle(title);

            libraryMember.checkOutItem(item);
        }
    }

    // 3. Return an Item
    private void returnItem(){
        System.out.print("Enter your member ID: ");
        String memberId = userInput.nextLine();
        libraryMember = memberMap.get(memberId);

        if (!memberMap.containsKey(memberId)) {
            System.out.println("Invalid member ID. Please try again.");
        } else {
            libraryMember.listCheckedOutItems();

            if (!libraryMember.getCheckedOutItem().isEmpty()) {
                System.out.print("Enter the title of the item you want to return: ");
                String title = userInput.nextLine();
                System.out.println("-----------------------------------");

                // Search for the item in the library inventory
                item = library.searchItemsByTitle(title);

                libraryMember.returnItem(item);
            }
        }
    }

    // 4. List Available Items
    private void listAvailableItems(){
        library.listAvailableItems();
    }

    // 5. List Checked-Out Items
    private void listCheckedOutItems(){
        System.out.print("Enter your member ID: ");
        String memberId = userInput.nextLine();
        libraryMember = memberMap.get(memberId);

        if (!memberMap.containsKey(memberId)) {
            System.out.println("Invalid member ID. Please try again.");
        } else {
            libraryMember.listCheckedOutItems();
        }
    }

    // 6. Search for Items by Title
    private void searchItemsByTitle(){
        System.out.print("Enter the title to search: ");
        String title = userInput.nextLine();

        // Search for the item in the library inventory
        item = library.searchItemsByTitle(title);

        if (item != null) {
            System.out.println("Search Results for \"" + title + "\":");
            System.out.println(item.getDetails());
        } else {
            System.out.println("Item not found in the library inventory.");
        }
    }

    // 7. History of Checked-Out Items
    private void listCheckedOutHistory(){
        System.out.print("Enter your member ID: ");
        String memberId = userInput.nextLine();
        libraryMember = memberMap.get(memberId);

        if (!memberMap.containsKey(memberId)) {
            System.out.println("Invalid member ID. Please try again.");
        } else {
            libraryMember.listCheckedOutHistory();
        }
    }

    // 8. Admin Login
    private void adminLogin(){
        System.out.print("Enter admin username: ");
        String username = userInput.nextLine();
        System.out.print("Enter admin password: ");
        String password = userInput.nextLine();

        // Validate admin credentials
        if (username.equals("bwkt1n22") && password.equals("12345")) {
            // Admin login successful
            adminMenu();
        } else {
            System.out.println("Invalid admin credentials. Please try again.");
        }
    }

    private void adminMenu(){
        int adminOption;
        do {
            displayAdminMenu();
            adminOption = userInput.nextInt();
            userInput.nextLine();
            System.out.println("-----------------------------------");

            switch (adminOption) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    listAllCheckedOutItems();
                    break;
                case 4:
                    System.out.println("Exiting admin mode.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again (1-4).");
                    break;
            }
        } while (adminOption != 4);
    }

    private void displayAdminMenu(){
        System.out.print("""
                -----------------------------------
                Admin Menu:
                1. Add Item
                2. Remove Item
                3. List All Checked-Out Item
                4. Exit Admin Mode
                -----------------------------------
                Enter your choice:""");
    }

    // Admin: 1. Add Item
    private void addItem(){
        System.out.print("Enter the type of item (book, DVD, magazine): ");
        String itemType = userInput.nextLine();

        switch (itemType.toLowerCase()) {
            case "book":
                Book newBook = new Book("", "", "", "", "", 0);
                newBook.input();
                library.addItem(newBook);
                System.out.println("Book added successfully.");
                break;
            case "dvd":
                DVD newDVD = new DVD("", "", "", "", "");
                newDVD.input();
                library.addItem(newDVD);
                System.out.println("DVD added successfully.");
                break;
            case "magazine":
                Magazine newMagazine = new Magazine("", "", "", "", "");
                newMagazine.input();
                library.addItem(newMagazine);
                System.out.println("Magazine added successfully.");
                break;
            default:
                System.out.println("Invalid item type. Please try again.");
                break;
        }
    }


    // Admin: 2. Remove Item
    private void removeItem(){
        System.out.print("Enter the title of the item to be removed: ");
        String title = userInput.nextLine();

        library.removeItem(title);
    }

    // Admin: 3. List All Checked-Out Item
    private void listAllCheckedOutItems(){
        library.listAllCheckedOutItems();
    }

    public static void main(String[] args){
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        libraryManagementSystem.run();
    }
}