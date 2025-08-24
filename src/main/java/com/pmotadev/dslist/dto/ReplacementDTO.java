package com.pmotadev.dslist.dto;

public class ReplacementDTO {
    private int sourceIndex;
    private int destinationIndex;

    public ReplacementDTO() {
    }

    public ReplacementDTO(Long listId, int sourceIndex, int destinationIndex) {
        this.sourceIndex = sourceIndex;
        this.destinationIndex = destinationIndex;
    }

    public int getSourceIndex() {
        return sourceIndex;
    }

    public void setSourceIndex(int sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    public int getDestinationIndex() {
        return destinationIndex;
    }

    public void setDestinationIndex(int destinationIndex) {
        this.destinationIndex = destinationIndex;
    }
}
