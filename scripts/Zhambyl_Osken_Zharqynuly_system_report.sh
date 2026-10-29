#!/bin/bash
# System monitoring report for Zhambyl Osken Zharqynuly (IT-2 2307, ID 37437)
# Usage: ./scripts/Zhambyl_Osken_Zharqynuly_system_report.sh

STUDENT_NAME="Zhambyl Osken Zharqynuly"
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
LOG_FILE="${SCRIPT_DIR}/../logs/Zhambyl_Osken_Zharqynuly_system_report.log"

{
  echo "==================================================="
  echo "System report for: ${STUDENT_NAME}"
  echo "Group: IT-2 2307 | ID: 37437"
  echo "Date and time: $(date '+%Y-%m-%d %H:%M:%S %Z')"
  echo "Username: $(whoami)"
  echo "Operating system: $(grep PRETTY_NAME /etc/os-release | cut -d= -f2 | tr -d '\"')"
  echo "Kernel version: $(uname -r)"
  echo "---------------------------------------------------"
  echo "CPU information:"
  grep -m1 'model name' /proc/cpuinfo | awk -F: '{print "  CPU model:" $2}'
  echo "  Logical CPUs: $(nproc)"
  echo "Memory information:"
  free -h | sed 's/^/  /'
  echo "---------------------------------------------------"
  echo "Disk usage (root filesystem):"
  df -h / | sed 's/^/  /'
  echo "Available disk space:"
  df -h / | awk 'NR==2 {print "  Available: " $4 " of " $2}'
  echo "==================================================="
  echo
} | tee -a "$LOG_FILE"
