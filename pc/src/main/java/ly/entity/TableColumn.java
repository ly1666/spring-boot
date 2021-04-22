package ly.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author ly
 */
@Setter
@Getter
@ToString
public class TableColumn implements Serializable {
    private String id;

    private String assetType;

    private String assetName;

    private String assetBalanc;

    private String proportion;

    private String term;

    private String whether;

    private String grade;

    private String mainGrade;

    private String ratingGencies;
}
