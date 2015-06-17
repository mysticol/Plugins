1- INSTALLATION

    - Cloner les sources du projet depuis Github sur votre poste de travail
      https://github.com/mysticol/Plugins.git 
      ou bien récupérer-les depuis une clé-usb

    – Ouvrez Eclipse en sélectionnant le workspace que vous venez de cloner (Plugins)
    - Importer les projets dans Eclipse : File => Import => General => Existing projects into workspace 
      puis les selectionner tous (le message d'avertissement que les projets existent déjà
      peut être ignoré)
    - Sur système Linux, en cas d'erreur lors du chargement du Lanceur,
      changer l'encodage du fichier config.txt en UTF-8 (Clic droit sur le fichier config.txt => Proprietés => Ressource)
 




2- LANCEMENT

    - Dans Eclipse créér une nouvelle configuration : onglet run, puis run configurations,
      cliquer sur new launch configuration, faire un search pour trouver la Main class,
      il s'agit de core.Main. Ensuite dans l'onglet Classpath, dans Bootstap Entries,
      faire Add projects et sélectionner tous les projets. Terminer en cliquant sur le
      bouton Run. Le jeu se lance
    - Si le projet ne se lance pas, cela vient probablement de la version de Java :
      Changer la version vers la 1.7 :
      Window => Préférence => Java Compiler => 1.7
  



3- UTILISATION

    - Le but du jeu est de déplacer son héros sur la carte afin de récolter des ressources
      et de combattre des monstres.
      Déplacement : cliquer sur une cellule adjacente à celle de votre héros et cliquer
      sur le bouton déplacer
      Attaquer : lorsque un monstre est sur une case adjacente à votre héros, cliquer
      sur cette case puis sur le bouton attaquer
      Recolter : lorsque votre héros se trouve sur une cellule contenant une ressource,
      cliquer sur le bouton récolter pour la récupérer
      Affichage ressource : un clic sur le bouton ressource permet d'afficher l'état des lieux
      des ressources du héros : vie, or et nourriture
      Affichage credits : un clic sur le bouton credits permet d'afficher les développeurs
      ayant participé au projet
      Map : un clic sur le bouton map permet de revenir au jeu

   