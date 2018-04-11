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

#ffmpeg -i "$IN" -pix_fmt rgb24 -r 3 -f gif - | gifsicle --optimize=3  > "$OUT"

#-s 600x400 
#--delay=3
# -r 3
ffmpeg -i "$IN" -vf scale=800:-1 -r 10 -f image2pipe -vcodec ppm - |\
convert -delay 5 -layers Optimize -loop 0 - "$OUT"

