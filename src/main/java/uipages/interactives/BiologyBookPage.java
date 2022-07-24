package uipages.interactives;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import uipages.BasePage;
import utils.GuiControl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BiologyBookPage extends BasePage {

    private final GuiControl insightPopupDismiss = new GuiControl(getElementMap().get("insightPopupDismiss"), webDriver);
    private final GuiControl vocabularyTerms = new GuiControl(getElementMap().get("vocabularyTerms"), webDriver);
    private final GuiControl hyperlinkedWords = new GuiControl(getElementMap().get("hyperlinkedWords"), webDriver);
    private final GuiControl vocaDefinitionPopup = new GuiControl(getElementMap().get("vocaDefinitionPopup"), webDriver);
    private final GuiControl imagesInline = new GuiControl(getElementMap().get("imagesInline"), webDriver);
    private final GuiControl videoContainer = new GuiControl(getElementMap().get("videoContainer"), webDriver);
    private final GuiControl didYouKnowSection = new GuiControl(getElementMap().get("didYouKnowSection"), webDriver);
    private final GuiControl videoIframe = new GuiControl(getElementMap().get("videoIframe"), webDriver);
    private final GuiControl embedVideoIframe = new GuiControl(getElementMap().get("embedVideoIframe"), webDriver);
    private final GuiControl modalityTitle = new GuiControl(getElementMap().get("modalityTitle"), webDriver);
    public final GuiControl canonicalData = new GuiControl(getElementMap().get("canonicalData"), webDriver);
    public final GuiControl pageDescription = new GuiControl(getElementMap().get("pageDescription"), webDriver);
    public final GuiControl mathEquation = new GuiControl(getElementMap().get("mathEquation"), webDriver);

    public BiologyBookPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    // Expected Vocabulary terms
    String[] vocabularyTermsExpected = {"Scientific", "investigations", "science", "heart", "observations", "sight", "hearing", "Variable", "plaque", "stabilizing",
            "smell", "taste", "observe", "wings", "hypothesis", "birds", "prey", "prediction", "evidence", "experiment", "shivering", "lungs", "Red", "phloem", "Heterozygotes",
            "Biology", "migration", "Independent", "variables", "dependent", "Sample", "size", "repetition", "scientific", "exoskeleton", "amylase", "xylem", "vector", "directional",
            "investigation", "plant", "variable", "control", "scale", "organisms", "microscope", "compound", "hypotheses", "Joint", "hemoglobin", "lung", "evaporation", "disruptive",
            "theories", "cell", "theory", "germ", "law", "of", "evolution", "by", "natural", "selection", "species", "sexual", "Asexual", "double", "transpiration", "dimorphism",
            "offspring", "genes", "Experiments", "anthrax", "tuberculosis", "unsaturated", "fatty", "acids", "cells", "organic", "antibodies", "Chargaff’s", "telophase",
            "Organisms", "energy", "saturated", "Animals", "products", "membranes", "Molecule", "acid", "carbohydrates", "proteins", "Science", "rules", "cuticle", "exons",
            "food", "stomach", "enzyme", "blood", "cardiovascular", "disease", "arteries", "atherosclerosis", "Chemical", "reactions", "silk", "site", "guard", "chromatid",
            "Reactants", "equation", "elements", "product", "bonds", "molecule", "glucose", "cellular", "respiration", "chemical", "code", "pairs", "vessels", "anaphase",
            "Biochemical", "endothermic", "exothermic", "ecosystem", "Products", "Respiration", "activation", "movement", "metabolism", "nucleotides", "Pollen", "prophase",
            "animal", "organism", "biochemistry", "biology", "Exothermic", "catabolic", "anabolic", "reaction", "amino", "protein", "nucleotide", "substrate", "phase", "introns",
            "brain", "genetic", "material", "controls", "molecular", "bacterium", "strain", "vaccine", "pathogens", "pneumonia","virus", "polynucleotide", "mitotic", "bones", "Virus", "retrovirus",
            "pandemic", "transformation", "RNA", "conclusion", "community", "viruses", "bacteriophages", "reproduce", "competition", "Amino", "complementary", "Phase", "Regulatory",
            "Species", "flowers", "pollination", "Pollinator", "pollen", "nectar", "bird", "symbiotic", "relationship", "soil", "abiotic", "backbone","polarity", "regulatory",
            "interdependence", "Symbiosis", "parasites", "adaptation", "bacteria", "fungi", "nutrients", "Evidence", "Dinosaur", "biosphere", "base", "adhesion", "Cancer", "Biochemistry",
            "fossils", "multicellular", "biodiversity", "Charles", "Darwin", "adaptations", "animals", "Wallace", "molecules", "Cellular", "Hydrolysis", "hydrogen", "tumor", "artificial", "Lyell", "Lamarck", "naturalist",
            "solutions", "bases", "enzymes", "stomach", "food", "ions", "chemical", "equation", "mucus", "tadpoles", "connective", "monomers", "cohesion", "Synthesis", "Homo", "inheritance", "acquired", "characteristics",
            "Cells", "digestive", "system", "digestion", "pepsin", "small", "intestine", "organ", "pancreas", "antibiotics", "population", "sugar", "veins", "pollinate", "sapiens", "Malthus", "Population",
            "cytoplasm", "cytoskeleton", "microtubules", "microfilaments", "cell", "membrane", "nucleus", "cytosol", "muscle", "semi-conservative", "Cytokinesis", "Endothermic", "dinosaur", "paleontologists",
            "plasma", "membrane", "biochemical", "reactions", "prokaryotic", "division", "vesicles", "daughter", "stems", "kingdom", "helix", "Prokaryotic", "phenotypes", "predator", "feces", "pool",
            "intermediate", "filaments", "polymers", "tubulin", "centrosome", "spindle", "cilia", "flagella", "actin", "pseudopodia", "myosin", "contraction", "Organelles", "Protists", "sickle-cell",
            "phagocytes", "white", "blood", "bacteria", "nuclear", "envelope", "keratin", "reproduction", "plant", "metaphase", "DNA", "replication", "chromosomes", "tissues", "Reproduction", "malaria",
            "DNA", "nuclear", "envelope", "nucleolus", "ribosomes", "cell", "cell", "organelle", "mitochondria", "motility", "organism", "genes", "dihybrid", "cross", "sample", "alga", "anemia",
            "RNA", "chromosomes", "gene", "expression", "product", "human", "body", "gametes", "chromatin", "genetic", "material", "tissue", "denaturing", "epidermis", "endosymbiosis", "histone", "protozoa",
            "rough", "endoplasmic", "reticulum", "ribosomal", "RNA", "(rRNA)", "rRNA", "amino", "acids", "synthesis", "Mitochondria", "kidney", "simple", "Chitin", "condensation", "hox", "tumor-suppressor", "proto-oncogenes",
            "Ribosomes", "synthesis", "organelles", "nucleus", "Eukaryotic", "ribosomal", "RNA", "eukaryotic", "prokaryotic", "cytoplasm", "epithelial", "Cellulose", "mesophyll", "enhancers", "TATA", "box", "Homeobox",
            "endoplasmic", "reticulum", "(ER)", "nuclear", "envelope", "Ribozymes", "RNA", "chemical", "reactions", "translation", "amino", "acids", "polypeptide", "messenger", "RNA", "(mRNA)", "parasite",
            "cell", "membrane", "cellular", "respiration", "organic", "compounds", "ATP", "(adenosine", "triphosphate)", "cell", "division", "red", "blood", "cells", "photosystems", "Big", "Bang", "nuclei",
            "matrix", "cristae", "Prokaryotes", "DNA", "endosymbiotic", "theory", "host", "cell", "reproduce", "plant", "chloroplasts", "Animal", "organelles", "cell", "wall", "world", "HMS", "Beagle", "Galápagos",
            "central", "vacuole", "plastids", "food", "photosynthesis", "cellulose", "polysaccharides", "nutrients", "Microtubules", "enzymes", "lignin", "tonoplast", "monosaccharide", "Immunodeficiency",
            "vacuole", "flowers", "starch", "ribosomes", "DNA", "bacteria", "Chromoplasts", "petals", "fruit", "Leucoplasts", "tissues", "lipid", "monosaccharides", "carriers", "traits", "Islands",
            "model", "stroma", "thylakoids", "grana", "thylakoid", "chlorophyll", "protists", "eukaryotes", "Osmotic", "pressure", "balance", "Fish", "factors", "monomer", "isomers", "Mosaic", "habitats",
            "hypertonic", "isotonic", "selectively", "permeable", "solution", "concentration", "gradient", "hypotonic", "equilibrium", "diffusion", "red", "blood", "plasmolysis", "Enzymes", "webs",
            "contractile", "vacuole", "active", "transport", "electrochemical", "nerve", "axons", "carrier", "potential", "Vesicles", "Endocytosis", "exocytosis", "immune", "element", "Calvin",
            "vesicle", "Phagocytosis", "Pinocytosis", "organism", "lipids", "phospholipid", "bilayer", "glucose", "cells", "energy", "Carbohydrate", "cellular respiration", "nucleic", "reactant",
            "protein", "fish", "Food", "chemical", "bonds", "organic", "molecules", "DNA", "reservoir", "elements", "producer", "consumer", "photosynthesis", "chlorophyll", "molecule", "ABO", "Polygenic",
            "NADPH", "blood", "nectar", "organisms", "animal", "genes", "energy", "food", "autotrophs", "photosynthesis", "nutrients", "carbohydrates", "biome", "Protist", "fruits", "Autotrophs", "interphase",
            "extremophiles", "Consumers", "chemoautotrophs", "heterotrophs", "greenhouse", "gas", "greenhouse", "effect", "global", "warming", "organisms", "colonial", "organisms", "cooperation", "multicellular", "organism",
            "tissues", "organs", "organ", "systems", "DNA", "proteins", "mammal", "prokaryotes", "eukaryotes", "amoeba", "metabolism", "respiration", "biofilm", "bacteria", "biofilm", "labor", "liver", "Algae", "red-green", "Red-green",
            "genus", "fossils", "multicellularity", "species", "Colonial", "Theory", "food", "microscope", "brain", "flatworm", "nerve", "stem", "digestive", "system", "stomach", "pancreas", "pancreas", "bladder", "enzymes", "incomplete",
            "bladder", "enzymes", "nutrients", "blood", "autotrophs", "heterotrophs", "photosynthesis", "cellular", "respiration", "energy", "food", "organisms", "carbohydrate", "organic", "molecules", "algae", "over", "color", "codominance",
            "Bacteria", "transformation", "producers", "food", "chains", "animals", "fungi", "protists", "decomposers", "chemosynthesis", "Ecosystems", "chemical", "bonds", "glucose", "cells", "ATP", "products", "Centrioles", "blindness",
            "reactants", "recycle", "atmosphere", "chemical", "equation", "product", "starch", "respiration", "essential", "consumers", "capillaries", "glycolysis", "alcoholic", "fermentation", "aerobic", "respiration", "anaerobic", "respiration", "lactic",
            "pyruvate", "NADH", "chloroplast", "catalysts", "light", "carbon", "fixation", "RuBisCo", "stomata", "Metabolism", "Electron", "chain", "chloroplasts", "product", "light", "reactions","chlorophyll", "molecule", "enzyme", "resistance",
            "photolysis", "ions", "transformation", "species", "algae", "cells", "animals", "atmosphere", "organisms", "respiration", "electron", "transport", "active", "electrochemical", "gradient", "thylakoids", "chemiosmotic", "concentration",
            "membrane", "protein", "ion", "channel", "synthase", "transport", "electron", "chain", "NADPH", "chemical", "bond", "frog", "homeostasis", "seed", "Fungus", "disaccharide", "polysaccharide", "mitochondrion", "autosomes", "splicing",
            "Bone", "Smooth", "Skeletal", "Cardiac", "vacuoles", "semipermeability", "hydrophilic", "hydrophobic", "Fluid", "mosaic", "Cilia", "semipermeable", "Integral", "Peripheral", "ion", "channels", "Golgi", "variation", "histones", "crop",
            "apparatus", "centrioles", "Lipids", "smooth", "calcium", "drug", "Lysosomes", "Peroxisomes", "replicate", "chromosome", "mitosis", "Movement", "facilitated", "passive", "Channel", "gated", "Ion", "tadpole", "gonads", "SRY", "trait",
            "stimulus", "Glucose", "neurons", "impulse", "Dialysis", "kidneys", "Homeostasis", "minerals", "Krebs", "cycle", "walls", "bone", "Proteins", "osmosis", "endocytosis", "wetlands", "Transport", "cell", "bacterium", "crossing", "pedigree",
            "bone", "blood", "organism", "parent cell", "daughter", "cells", "prokaryotes", "eukaryotes", "prokaryotic", "cells", "organelles", "protein", "binary", "fission", "replication", "cell", "membrane", "cytoplasm", "cell", "wall", "mitosis", "diploid",
            "cytokinesis", "cell", "division", "genetic", "material", "nucleus", "parent", "cycle", "chromatin", "centromere", "genes", "alleles", "homologous", "Chromosomes", "egg", "ovum", "nucleus", "genetic", "material", "cytoplasm", "meiosis", "haploid", "gametes",
            "fertilization", "spermatogenesis", "sperm", "oogenesis", "secondary", "spermatocytes", "spermatids", "flagellum", "mitochondria", "energy", "zygote", "organelles", "proteins", "nucleic", "acids", "embryo", "oogonia", "ovaries", "chromosomes", "primary", "oocyte",
            "nutrients", "polar", "body", "haploid", "Sexual", "reproduction", "gametes", "haploid", "life", "cycle", "alternation", "of", "generations", "sporophyte", "gametophyte", "Spore", "independent", "assortment", "Codominance", "Incomplete", "dominance", "", "",
            "random", "tetrad", "recombination", "Mendel", "experiments", "Seed", "flower", "offspring", "P", "generation", "F1", "generation", "F2", "generation", "prediction", "self-pollinate", "law", "of", "segregation", "observations", "law", "gametes",
            "random", "tetrad", "recombination", "asexual", "Cell", "fragmentation", "budding", "predators", "vertebrates", "parthenogenesis", "eggs", "Nerve", "fern", "fetus", "Nucleotide", "Haploid", "puberty", "genome", "polyps", "medusae", "autosomes", "Sex-linked",
            "heredity", "genetics", "Observations", "anther", "stigma", "ovary", "cross-pollination", "allele", "genotypes", "Punnett", "square", "seeds", "communicate", "locus", "genotype", "homozygote", "heterozygote", "phenotype", "dominant", "recessive", "probability",
            "random", "tetrad", "recombination", "asexual", "Cell", "fragmentation", "budding", "predators", "vertebrates", "parthenogenesis", "eggs", "Nerve", "fern", "fetus", "Nucleotide", "Haploid", "puberty", "genome", "polyps", "medusae", "gene", "cloning",
            "polymerase", "chain", "reaction", "genetic", "disorders", "ligation", "therapy", "enzyme", "ligase", "plasmid", "chromosome", "replicate", "recombinant", "engineering", "denaturing", "annealing", "extension", "Taq", "polymerase", "nucleotides", "Cloning",
            "Human", "Genome", "Project", "biotechnology", "Ethical,", "Legal", "and", "Social", "Issues", "society", "ecosystems", "mutations", "pregnancy", "disorder", "mutation", "X-linked", "joints", "Vitamin", "rickets", "nondisjunction", "zygotes", "X", "sex",
            "Y", "hormone", "testosterone", "counselors", "prenatal", "amniocentesis", "cancer", "linked", "Alleles", "sex-linked", "X-linked", "linkage", "map", "cytokine", "Insulin", "type", "1", "diabetes", "pharmacogenomics", "synthetic", "transgenic", "crops", "transgenic", "dogma",
            "eukaryotic cells", "protein synthesis", "molecular biology", "transcription", "template", "factor", "cis-regulatory", "activator", "repressor", "promoter", "Enhancers", "initiation", "complex", "Transcription", "operons", "promoter", "operator", "lac", "operon", "repressor",
            "Mutations", "mutagen", "populations", "point", "beneficial", "antibiotic", "drugs", "cystic", "fibrosis", "polygenic", "Model", "Paleozoic", "explosion", "Cambrian", "extinction", "mass", "sixth", "specialization", "Earth", "snowball", "climate", "fossil", "Era", "Linked",
            "ribosome", "central dogma of molecular biology", "messenger RNA", "elongation", "termination", "RNA polymerase", "complementary base pairs", "editing", "polyadenylation", "codons", "amino acids", "start", "stop", "codon", "reading", "frame", "tRNA", "Messenger RNA", "Ribosomal RNA",
            "Transfer", "chromosomal", "alterations", "melanin", "alleles", "somatic", "frameshift", "Messenger", "Ribosomal", "chromosomal alterations", "Point", "Cystic", "Fibrosis", "Klinefelter", "syndrome", "anticodon", "binomial", "nomenclature", "mammals", "mammary", "glands", "taxonomy", "taxa",
            "beak", "domain", "Eukarya", "Protista", "Fungi", "cephalopod", "dinosaurs", "herds", "record", "relative", "dating", "absolute", "clock", "Fruit", "geologic", "time", "Last", "Universal", "Common", "Ancestor", "Permian", "invertebrates", "trilobites", "vascular", "plants", "nonvascular",
            "amphibians", "reptiles", "Pangaea", "Mesozoic", "Era", "extinctions", "ferns", "conifers", "Laurasia", "Gondwanaland", "Hardy-Weinberg", "theorem", "frequencies", "mating", "falsifiable", "neutral", "sarcomeres", "pores", "spindles", "Mass", "fitness", "Mating", "flight", "pollinator", "eukaryote",
            "proboscis", "pollinators", "habitat", "phylogeny", "clade", "phylogenetic", "tree", "cladistics", "cladograms", "reptile", "primers", "Linnaean", "classification", "Retroviruses", "gradualism", "punctuated", "speciation", "sympatric", "Macroevolution", "allopatric", "larvae",
            "sauropsids", "amniotic", "amniotes", "lobe-finned", "cranium", "hagfish", "embryos", "chordates", "notochord", "gills", "arthropods", "complete", "Tissues", "choanocyte", "vertebrate", "invertebrate", "drift", "flow", "bottleneck", "founder", "communities", "microevolution", "macroevolution",
            "proboscis", "pollinators", "habitat", "phylogeny", "clade", "phylogenetic", "tree", "cladistics", "cladograms", "reptile", "primers", "Linnaean", "classification", "Retroviruses", "gradualism", "punctuated", "speciation", "sympatric", "Macroevolution", "allopatric", "larvae", "adaptive", "radiation",
            "beaks", "photoautotrophs", "prokaryote", "Diatoms", "Seaweed", "Cyanobacteria", "Herbivores", "Carnivores", "frogs", "Omnivores", "Scavengers", "Detritivores", "detritus", "earthworms", "Saprotrophs", "mushrooms", "Photosynthesis", "wetland", "Freshwater", "biomes", "aphotic", "zone", "runoff",
            "estuary", "rate", "growth", "immigration", "emigration", "movements", "dispersal", "Migration", "weather",

    };

    // Expected hyperlinked concepts
    String[] hyperlinkedConceptExpected = {"development", "senses", "eyes", "research", "marine", "laboratory", "lenses", "theory of evolution", "terrestrial",
            "human body", "lipid", "water", "temperature", "Triglycerides", "Phospholipids", "weight", "Conservation", "heat", "Ph", "Transcription factors",
            "history of life", "Origin of Species", "color", "acid", "plant growth", "pH", "Water", "mixture", "composition", "atom", "element",
            "concentration", "acid", "base", "color", "Composition", "plant", "cell", "color", "liquid", "mixture", "X-rays", "agriculture",
            "sun", "roots", "plant cell", "solid", "membrane proteins", "Nobel Prize", "voltage", "electrical potential", "conduction", "Research",
            "the environment", "muscles", "color", "heat", "solar energy", "energy level", "chemical formula", "weight", "machine", "base", "gas",
            "boiling", "efficiency", "location", "sponges", "Mars", "capillaries", "Acid", "electron", "vertical angles", "regular and irregular polygons",
            "Equilateral triangles", "congruent triangles", "trapezoids", "rectangles", "parallelograms", "kites", "area of a parallelogram", "tropical",
            "converse of the Pythagorean Theorem", "Pythagorean Theorem and its converse", "Pythagorean triples", "distance formula", "surface area",
            "volume", "slope", "circumference", "arc length","area of a sector", "corresponding angles", "lines of symmetry", "symmetry", "Composite transformations",
            "order of operations", "sequence", "tan", "complementary angles", "supplementary angles", "sin", "Law of Sines", "Law of Cosines", "30-60-90 right triangles",
            "45-45-90 right triangles", "ellipses", "combination", "centimeters", "meters", "parabolas", "hyperbolas", "equation of an ellipse", "degenerate conics",
            "completing the square", "midpoint formula", "median", "medians", "Pythagorean Theorem", "the Pythagorean Theorem", "conditional probability",
            "Addition Rule", "Fundamental Counting Principle", "permutation", "color", "plant characteristics", "pea plants", "nuclear power", "origin of species",
            "solar energy", "potential energy", "concentration", "Human organs", "Archaea", "carbohydrate", "compound", "protein", "speed", "fossil",
            "nucleic acid", "DNA and RNA", "amino acids", "genetic code", "enzyme", "Structure of Water", "ionic bond", "melting", "Darwin",
            "insects", "plasma", "cell structure", "cytoplasm", "cell communication", "parts of the cell", "modeling", "distance",
            "photosynthesis", "parts of the cell", "polar molecules", "polar molecules", "potential energy", "Noble Prize", "research", "PCR",
            "evolution of life", "Continental drift", "Quarks", "volcanoes", "clouds", "comets", "asteroids", "central dogma", "Characteristics of life", "archaea", "Terrestrial",
            "Aquatic",
    };


    List<String> vocabularyTermsListExpected = new ArrayList<>(Arrays.asList(vocabularyTermsExpected));
    List<String> hyperlinkedConceptListExpected = new ArrayList<>(Arrays.asList(hyperlinkedConceptExpected));

    public boolean verifyModalityPageTitle(String expectedModalityTitle) {
        if (modalityTitle.isElementPresent()) {
            logger.info("Verified the modality title on the modality page.");
            if (webDriver.getTitle().split("\\|")[0].trim().equals(expectedModalityTitle)) {
                logger.info("Modality Title is correct and verified");
                return true;
            }
        }
        return false;
    }

    public boolean verifyCanonicalMetaTag() {
        if (canonicalData.getAttribute("href").equals(webDriver.getCurrentUrl())) {
            logger.info("Canonical Tag is present and verified");
            return true;
        }
        return false;
    }

    public boolean verifyTheVocabularyTermsOfBiologyBook() {
        boolean result = false;
        List<WebElement> vocabularyTermsActual = vocabularyTerms.getWebElements();
        logger.info("The size of Vocabulary Terms are :" + vocabularyTermsActual.size());
        if (!vocabularyTermsActual.isEmpty()) {
            for (WebElement terms : vocabularyTermsActual) {
                if (terms.isDisplayed()) {
                    String vocaTerm = "xpath" + "_TBD_" + "//span[@data-term=\"" + terms.getAttribute("data-term") + "\"]";
                    GuiControl vocaTermElement = new GuiControl(vocaTerm, webDriver);
                    if (vocabularyTermsListExpected.contains(terms.getText())) {
                        logger.info("Vocabulary term is present in the Expected list." + terms.getText());
                        waitForSec(2);
                        Actions actions = new Actions(webDriver);
                        actions.moveToElement(vocaTermElement.getWebElement());
                        vocaTermElement.mouseHoverWithJavaScript();
                        actions.clickAndHold(vocaTermElement.getWebElement());
                        waitForSec(2);
                        if (vocaDefinitionPopup.isDisplayed()) {
                            logger.info("Vocabulary term " + terms.getText() + " have mouse hover description");
                            result = true;
                        } else {
                            logger.info("Vocabulary term " + terms.getText() + " do not have mouse hover description");
                            return false;
                        }
                    } else {
                        logger.info("Vocabulary term is not present in the Expected list" + terms.getText());
                        return false;
                    }
                }
            }
        } else {
            reportLog("This concept doesn't have the Vocabulary terms.");
            return true;
        }
        return result;
    }

    public boolean verifyHyperLinkTagsAndParseTheURLOfTags() {
        boolean result = false;
        List<WebElement> hyperLinkedWordsActual = hyperlinkedWords.getWebElements();
        logger.info("The size of hyperLinked Words are :" + hyperLinkedWordsActual.size());

        if (!hyperLinkedWordsActual.isEmpty()) {
            for (WebElement word : hyperLinkedWordsActual) {
                if (word.isDisplayed()) {
                    logger.info("Hyperlink word is displayed " + word.getText());
                    if (hyperlinkedConceptListExpected.contains(word.getText())) {
                        reportLog("hyperLink word is present in the Expected list. " + word.getText());

                        logger.info("Parse the hyper tag URL's and Verify the status code.");
                        String hyperTagURL = word.getAttribute("href");
                        logger.info("The hyper tag URL is : " + hyperTagURL);

                        try {
                            URL url = new URL(hyperTagURL);
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.connect();

                            int statusCode = httpURLConnection.getResponseCode();
                            reportLog("The Status code of " + word.getText() + " hyper tag for the URL : " + word.getAttribute("href") + "is : " + statusCode);

                            if (statusCode >= 200 && statusCode < 400) {
                                reportLog("The URL is working : " + word.getAttribute("href"));
                                result = true;
                            } else {
                                reportLog("The URL is broken : " + word.getAttribute("href"));
                                return false;
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            reportLog("This concept doesn't have the hyper tags terms.");
            return true;
        }
        return result;
    }

    public boolean verifyTheImagesOfBiologyBook() {
        List<WebElement> conceptImages = imagesInline.getWebElements();
        logger.info("The size of concept images are :" + conceptImages.size());

        int i = 1;
        if (!conceptImages.isEmpty()) {
            for (WebElement image : conceptImages) {
                if (image.isDisplayed()) {
                    logger.info("The image is present.");
                    if (verifyStatusCodeIsCorrect(image.getAttribute("src"), "Image" + i)){
                        logger.info("Image " + i + " is not broken and loaded correctly");
                    } else {
                        logger.info("Image " + i + " is broken");
                        return false;
                    }
                } else {
                    logger.info("The image is not present");
                    return false;
                }
                i++;
            }
        } else {
            reportLog("This concept doesn't have the images.");
            return true;
        }
        return true;
    }

    public boolean verifyTheVideosOfBiologyBook() {
        List<WebElement> conceptVideoIframes = videoIframe.getWebElements();
        logger.info("The size of concept videos are :" + conceptVideoIframes.size());
        if (!conceptVideoIframes.isEmpty()) {
            for (WebElement iframe : conceptVideoIframes) {
                webDriver.switchTo().frame(iframe);
                waitForSec(2);
                if (embedVideoIframe.isElementPresent()) {
                    webDriver.switchTo().frame(embedVideoIframe.getWebElement());
                }
                if (videoContainer.isDisplayed()) {
                    logger.info("The video is present.");
                } else {
                    logger.info("The video is not present");
                    return false;
                }
                webDriver.switchTo().defaultContent();
            }
        } else {
            reportLog("This concept doesn't have the videos.");
            return true;
        }
        return true;
    }

    public boolean verifyDidYouKnowSection() {
        if (didYouKnowSection.isElementPresent()) {
            if (didYouKnowSection.getText().contains("DID YOU KNOW?")) {
                logger.info("Did you know section is verified.");
            }
        } else {
            reportLog("This concept doesn't have the Did You Know Section.");
        }
        return true;
    }

    public boolean verifyHTagsInBook() {
        for (int i = 1; i <= 5; i++) {
            String hTagsLocator = "xpath" + "_TBD_" + "//h" + i;
            GuiControl hTag = new GuiControl(hTagsLocator, webDriver);
            List<WebElement> hTagElements = hTag.getWebElements();
            if (!hTagElements.isEmpty()) {
                for (WebElement hElement : hTagElements) {
                    if (hElement.isDisplayed()) {
                        logger.info("Verified h" + i + " tag is displayed");
                        logger.info("Following Tag Text is " + hElement.getText());
                    } else {
                        logger.info("Following Tag text is not displayed");
                    }
                }
            } else {
                logger.info("Tag h" + i + " is not displayed");
            }
        }
        return true;
    }

    public boolean verifyMathEquationRenderedCorrect(){
        List<WebElement> mathEquations = mathEquation.getWebElements();
        reportLog("Total math Elements on page: " +mathEquations.size());
        if (!mathEquations.isEmpty()){
            for (WebElement mathElement : mathEquations) {
                String equation = mathElement.getText();
                if (equation != null && !equation.endsWith("{align*}")){
                    reportLog("Math Elements is: " + equation + " and it renders correct");
                } else {
                    reportLog("Math Elements is: " + equation + " add it has junk characters");
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verifyStatusCodeIsCorrect(String bookURL, String book){
        try {
            URL url = new URL(bookURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            int statusCode = httpURLConnection.getResponseCode();
            reportLog("The Status code of " + book + " hyper tag for the URL : " + bookURL + "is : " + statusCode);

            if (statusCode >= 200 && statusCode < 400) {
                reportLog("The URL is working : " + bookURL);
                return true;
            } else {
                reportLog("The URL is broken : " + bookURL);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void dismissInsightPopup(){
        waitForSec(2);
        if (insightPopupDismiss.isElementPresent()){
            insightPopupDismiss.click();
        }
    }

}