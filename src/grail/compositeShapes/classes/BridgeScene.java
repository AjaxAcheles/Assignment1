package grail.compositeShapes.classes;
import grail.compositeShapes.interfaces.AvatarInterface;
import grail.compositeShapes.interfaces.BridgeSceneInterface;
import tags301.Comp301Tags;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags(Comp301Tags.BRIDGE_SCENE)
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Arthur", "Lancelot", "Robin", "Galahad", "Guard"})
public class BridgeScene implements BridgeSceneInterface {
    private AvatarInterface arthur;
    private AvatarInterface lancelot;
    private AvatarInterface robin;
    private AvatarInterface galahad;
    private AvatarInterface guard;

    public BridgeScene() {
        this.arthur = new Avatar(100, 200, "I am Arthur", "images/arthur.jpg");
        this.lancelot = new Avatar(300, 200, "I am Lancelot", "images/lancelot.jpg");
        this.robin = new Avatar(500, 200, "I am Robin", "images/robin.jpg");
        this.galahad = new Avatar(700, 200, "I am Galahad", "images/galahad.jpg");
        this.guard = new Avatar(900, 200, "I am random guard", "images/guard.jpg");
    }

    @Override
    public AvatarInterface getArthur() {
        return this.arthur;
    }

    @Override
    public AvatarInterface getLancelot() {
        return this.lancelot;
    }

    @Override
    public AvatarInterface getRobin() {
        return this.robin;
    }

    @Override
    public AvatarInterface getGalahad() {
        return this.galahad;
    }
    
    @Override
    public AvatarInterface getGuard() {
        return this.guard;
    }
}