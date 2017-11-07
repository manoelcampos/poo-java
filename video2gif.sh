#!/bin/bash
clear

if [ $# -eq 0 ]; then
   echo "Usage: $0 video-file-name [output-file-name]"
   exit -1
fi

IN="$1"
#Removes the input file extension
OUT="${IN%.*}.gif"

if [ $# -gt 1 ]; then
   OUT="$2"
fi

echo "Generating file $OUT"

#-s 600x400 
#--delay=3
# -r 3
ffmpeg -i "$IN" -pix_fmt rgb24 -r 3 -f gif - | gifsicle --optimize=3  > "$OUT"