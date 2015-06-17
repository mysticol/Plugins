1- INSTALLATION

    - Cloner les sources du projet depuis Github sur votre poste de travail
      https://github.com/mysticol/Plugins.git 
      ou bien r�cup�rer-les depuis une cl�-usb

    � Ouvrez Eclipse en s�lectionnant le workspace que vous venez de cloner (Plugins)
    - Importer les projets dans Eclipse : File => Import => General => Existing projects into workspace 
      puis les selectionner tous (le message d'avertissement que les projets existent d�j�
      peut �tre ignor�)
    - Sur syst�me Linux, en cas d'erreur lors du chargement du Lanceur,
      changer l'encodage du fichier config.txt en UTF-8 (Clic droit sur le fichier config.txt => Propriet�s => Ressource)
 




2- LANCEMENT

    - Dans Eclipse cr��r une nouvelle configuration : onglet run, puis run configurations,
      cliquer sur new launch configuration, faire un search pour trouver la Main class,
      il s'agit de core.Main. Ensuite dans l'onglet Classpath, dans Bootstap Entries,
      faire Add projects et s�lectionner tous les projets. Terminer en cliquant sur le
      bouton Run. Le jeu se lance
    - Si le projet ne se lance pas, cela vient probablement de la version de Java :
      Changer la version vers la 1.7 :
      Window => Pr�f�rence => Java Compiler => 1.7
  



3- UTILISATION

    - Le but du jeu est de d�placer son h�ros sur la carte afin de r�colter des ressources
      et de combattre des monstres.
      D�placement : cliquer sur une cellule adjacente � celle de votre h�ros et cliquer
      sur le bouton d�placer
      Attaquer : lorsque un monstre est sur une case adjacente � votre h�ros, cliquer
      sur cette case puis sur le bouton attaquer
      Recolter : lorsque votre h�ros se trouve sur une cellule contenant une ressource,
      cliquer sur le bouton r�colter pour la r�cup�rer
      Affichage ressource : un clic sur le bouton ressource permet d'afficher l'�tat des lieux
      des ressources du h�ros : vie, or et nourriture
      Affichage credits : un clic sur le bouton credits permet d'afficher les d�veloppeurs
      ayant particip� au projet
      Map : un clic sur le bouton map permet de revenir au jeu

   