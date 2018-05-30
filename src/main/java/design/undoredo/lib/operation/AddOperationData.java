package design.undoredo.lib.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by adarsh.sharma on 30/05/18.
 */
@Getter
@Setter
@AllArgsConstructor
public class AddOperationData extends OperationData {
    private int position;
    private String text;

}
