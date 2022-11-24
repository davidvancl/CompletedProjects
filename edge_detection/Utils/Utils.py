import cv2


def show(image):
    cv2.imshow('Image', image)
    cv2.waitKey(0)
