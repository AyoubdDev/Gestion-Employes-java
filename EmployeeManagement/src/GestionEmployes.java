import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class GestionEmployes {
    private static ArrayList<Employe> employes = new ArrayList<>();
    private static final int MAX_EMPLOYES = 50;
    private static Scanner scanner = new Scanner(System.in);

    // Méthode principale : démarre le programme et affiche le menu
    public static void main(String[] args) {
        printMenu();
    }

    // Affiche le menu principal et gère les interactions utilisateur
    public static void printMenu() {
        while (true) {
            System.out.println("\n===== Menu Gestion des Employés =====");
            System.out.println("1. Ajouter un employé");
            System.out.println("2. Modifier un employé");
            System.out.println("3. Supprimer un employé");
            System.out.println("4. Afficher tous les employés");
            System.out.println("5. Rechercher un employé");
            System.out.println("6. Calculer la masse salariale");
            System.out.println("7. Trier les employés par salaire");
            System.out.println("8. Quitter");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Nettoie le buffer

            switch (choix) {
                case 1 -> ajouterEmploye();
                case 2 -> modifierEmploye();
                case 3 -> supprimerEmploye();
                case 4 -> afficherEmployes();
                case 5 -> rechercherEmploye();
                case 6 -> System.out.println("Masse salariale : " + calculerMasseSalariale() + " €");
                case 7 -> trierEmployesParSalaire();
                case 8 -> System.exit(0);
                default -> System.out.println("Choix invalide !");
            }
        }
    }

    // Ajoute un nouvel employé à la liste s'il reste de la place
    public static void ajouterEmploye() {
        if (employes.size() >= MAX_EMPLOYES) {
            System.out.println("Impossible d'ajouter plus de 50 employés.");
            return;
        }
        System.out.print("ID : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Nettoie le buffer
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Poste : ");
        String poste = scanner.nextLine();
        System.out.print("Salaire : ");
        double salaire = scanner.nextDouble();

        employes.add(new Employe(id, nom, poste, salaire));
        System.out.println("Employé ajouté avec succès !");
    }

    // Modifie les informations d'un employé existant
    public static void modifierEmploye() {
        System.out.print("ID de l'employé à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Nettoie le buffer

        for (Employe e : employes) {
            if (e.getId() == id) {
                System.out.print("Nouveau nom : ");
                e.setNom(scanner.nextLine());
                System.out.print("Nouveau poste : ");
                e.setPoste(scanner.nextLine());
                System.out.print("Nouveau salaire : ");
                e.setSalaire(scanner.nextDouble());
                System.out.println("Employé modifié avec succès !");
                return;
            }
        }
        System.out.println("Employé non trouvé !");
    }

    // Supprime un employé en fonction de son identifiant
    public static void supprimerEmploye() {
        System.out.print("ID de l'employé à supprimer : ");
        int id = scanner.nextInt();

        employes.removeIf(e -> e.getId() == id);
        System.out.println("Employé supprimé avec succès !");
    }

    // Affiche tous les employés enregistrés
    public static void afficherEmployes() {
        if (employes.isEmpty()) {
            System.out.println("Aucun employé trouvé.");
            return;
        }
        employes.forEach(System.out::println);
    }

    // Recherche un employé par nom ou poste et affiche ses informations
    public static void rechercherEmploye() {
        System.out.print("Nom ou poste de l'employé : ");
        String critere = scanner.nextLine().toLowerCase();

        employes.stream()
                .filter(e -> e.getNom().toLowerCase().contains(critere) || e.getPoste().toLowerCase().contains(critere))
                .forEach(System.out::println);
    }

    // Calcule et retourne la somme totale des salaires de tous les employés
    public static double calculerMasseSalariale() {
        return employes.stream().mapToDouble(Employe::getSalaire).sum();
    }

    // Trie les employés par salaire, soit en ordre croissant, soit en ordre décroissant
    public static void trierEmployesParSalaire() {
        System.out.print("Ordre croissant (1) ou décroissant (2) ? ");
        int ordre = scanner.nextInt();

        employes.sort(ordre == 1 ? Comparator.comparing(Employe::getSalaire) :
                Comparator.comparing(Employe::getSalaire).reversed());

        afficherEmployes();
    }
}
