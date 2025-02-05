public class Employe {

    private int id;
    private String nom;
    private String poste;
    private double salaire;

    // Constructeur avec paramètres : initialise un employé avec des valeurs spécifiques
    public Employe(int id, String nom, String poste, double salaire) {
        this.id = id;
        this.nom = nom;
        this.poste = poste;
        this.salaire = salaire;
    }

    // Constructeur par défaut : permet de créer un employé sans valeurs initiales
    public Employe() {}

    // Getter : retourne l'identifiant de l'employé
    public int getId() { return id; }

    // Getter : retourne le nom de l'employé
    public String getNom() { return nom; }

    // Getter : retourne le poste de l'employé
    public String getPoste() { return poste; }

    // Getter : retourne le salaire de l'employé
    public double getSalaire() { return salaire; }

    // Setter : modifie le nom de l'employé
    public void setNom(String nom) { this.nom = nom; }

    // Setter : modifie le poste de l'employé
    public void setPoste(String poste) { this.poste = poste; }

    // Setter : modifie le salaire de l'employé
    public void setSalaire(double salaire) { this.salaire = salaire; }

    // Méthode toString : retourne une représentation textuelle d'un employé
    @Override
    public String toString() {
        return "Employe [id=" + id + ", nom=" + nom + ", poste=" + poste + ", salaire=" + salaire + "]";
    }

    // Méthode statique : compare deux employés par leur salaire (utile pour le tri)
    public static int compareParSalaire(Employe e1, Employe e2) {
        return Double.compare(e1.getSalaire(), e2.getSalaire());
    }
}
