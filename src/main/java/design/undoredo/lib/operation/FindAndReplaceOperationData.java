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
public class FindAndReplaceOperationData extends OperationData {
    private Integer position;
    private String originalText;
    private String newText;
}
