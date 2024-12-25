package com.airbnb_booking.payload;

import java.util.List;

public class ListPropertyDto
{
    private List<PropertyDto> propertyDto;
    private int totalPage;
    private int totalElement;
    private boolean lastPage;
    private boolean firstPage;
    private int pageNumber;

    public List<PropertyDto> getPropertyDto() {
        return propertyDto;
    }

    public void setPropertyDto(List<PropertyDto> propertyDto) {
        this.propertyDto = propertyDto;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(int totalElement) {
        this.totalElement = totalElement;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
