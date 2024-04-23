Informații privind necesarul de pal al mai multor piese de mobilier sunt păstrate într-un
fișierul mobilier.json. Palul este un material lemnos sub formă de placă obținut prin presarea de
lemn în combinație cu diferiți lianți. Pentru fiecare piesă de mobilier se memorează numele
piesei (birou, dulap, etajeră, etc) și informații privind plăcile de pal care o compun. Fiecare
placă de pal are o formă dreptunghiulară. Pentru fiecare placă de pal se memorează o descriere
a plăcii, lungimea şi lățimea exprimate in milimetri, orientarea fibrei, canturile pe care le are şi
numărul de bucăți din placa respectivă care intră în compoziția mobilierului. Sa se realizeze un
program care:
a) Citește datele despre piesele de mobilier din fișierul mobilier.json într-o listă de piese
de mobilier (List<Mobilier>) și le afișează
b) Afişează elementele de mobilier din colecție şi plăcile care le compun
c) Afişează caracteristicile plăcilor care compun o anumită piesă de mobilier
d) Afișează estimativ numărul colilor de pal necesare pentru realizarea unui anumit corp
de mobile știind că o coală de pal are dimensiunea 2800 x 2070 mm (pentru simplitate
se va ţine cont doar de arie, nu şi de posibilitatea de a realiza tăieturile)
Se vor implementa clasele:
- Clasa Mobilier, cu variabilele membre
o nume (String)
o lista plăcilor care o compun List<Placa> placi;

- Clasa Placa
o descriere (String cu valori precum usa, capac, laterală, raft mobil, raft fix, etc)
o lungime în milimetri (întreg)
o laţime în milimetri (întreg)
o orientare– enumerare cu valorile posibile LUNGIME, LATIME, ORICARE
o canturi (vector de 4 elemente boolean). Fiecare piesă de pal care face parte dintr-un
corp de mobilă, are 4 muchii. O anumită valoare booleană indică prezența sau
absența cantului pe muchia corespunzătoare.
o nr_bucati (int) 
