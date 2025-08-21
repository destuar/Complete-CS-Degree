# Cursor Rules: Note Formatting and Links

## Overview
These rules govern how to format notes and handle links in our Zettelkasten system. Follow these guidelines strictly to maintain consistency and avoid broken links.

## Note Formatting Rules

### 1. Zettelkasten Structure
- **Title**: Use descriptive, specific titles that capture the core concept
- **Introduction**: Start with a clear, concise definition of the concept
- **Sections**: Use `##` for main sections, `###` for subsections
- **Content**: Aim for comprehensive coverage suitable for PhD-level understanding
- **LaTeX**: Use proper LaTeX formatting for all mathematical expressions

### 2. Content Organization
- Begin with **Basic Definition** or **Basic Idea** section
- Include **Algorithm Steps** for algorithmic content
- Provide **Pseudocode** when applicable
- Cover **Time/Space Complexity** for algorithms
- Include **Applications** and **Examples**
- End with **Key Features** or **Important Notes**

### 3. Mathematical Notation
- Use `$...$` for inline math: `$O(n \log n)$`
- Use `$$...$$` for display math: `$$T(n) = 2T(n/2) + O(n)$$`
- Use `\begin{pmatrix}...\end{pmatrix}` for matrices
- Use `\mathbb{R}`, `\mathbb{Z}`, etc. for number sets
- Use `\Theta`, `O`, `\Omega` for asymptotic notation

### 4. Conciseness and Scannability
- **Avoid excessive scrolling**: Keep notes concise while maintaining completeness
- **Combine related sections**: Merge similar topics under unified headers
- **Use streamlined formatting**: Condense verbose explanations into concise explanations
- **Eliminate redundancy**: Remove repetitive or overly detailed explanations
- **Maintain scannability**: Use clear headers and consistent formatting for easy navigation

### 5. Enhanced Readability Techniques
- **Arrow notation**: Use → for sequential processes (e.g., "Parsing → Validation → Optimization")
- **Combined items**: Group related concepts (e.g., "Table/Column/Row-level: Granular access control")
- **Inline complexity**: Include complexity notation directly in descriptions where appropriate
- **Consistent formatting**: Maintain uniform structure throughout the note

## Link Rules - CRITICAL

### 1. Link Validation
- **NEVER create links to notes that don't exist**
- **ONLY link to notes that are already present in the `z_Obsidian Notes` directory**
- **Verify existence before creating any `[[]]` links**

### 2. Link Format
- Use double brackets: `[[Note Name]]`
- Use exact filename (without .md extension)
- Preserve case sensitivity
- Use descriptive link text when appropriate

### 3. Link Creation Process
1. **Check Directory First**: Use `list_dir` to verify what notes exist
2. **Search if Uncertain**: Use `file_search` to find exact filenames
3. **Create Link Only After Verification**: Ensure the target note exists
4. **Use Exact Filename**: Match the filename exactly as it appears

### 4. Common Existing Notes
Based on our current collection, these notes exist and can be linked:
- `[[QuickSort]]`
- `[[Master Method]]`
- `[[Strassen's Algorithm]]`
- `[[Nonlinear Equations]]`
- `[[Levenberg-Marquardt Algorithm]]`
- `[[Lagrange Multiplier]]`
- `[[Constrained Least Squares]]`
- `[[Regularized Inversion]]`
- `[[Multi-Objective Least Squares]]`
- `[[Pareto Optimal]]`
- `[[Control]]`
- `[[Least Squares]]`
- `[[RSelect Algorithm]]`
- `[[BucketSort Algorithm]]`
- `[[CountingSort Algorithm]]`
- `[[RadixSort Algorithm]]`
- `[[Kosaraju's Two-Pass Algorithm]]`
- `[[Database Management System (DBMS)]]`
- `[[Array]]`
- `[[Collection]]`
- `[[Abstract Data Types (ADTs)]]`
- `[[Matrix Multiplication]]`
- `[[Linear Equations]]`

### 5. Link Prohibitions
- **DO NOT** create links to concepts that don't have notes
- **DO NOT** create placeholder links
- **DO NOT** assume note existence
- **DO NOT** create links to external concepts without notes

## Content Creation Rules

### 1. When Creating New Notes
- Follow the established Zettelkasten format
- Use proper LaTeX formatting
- Include comprehensive coverage
- Link only to existing notes
- Maintain academic rigor suitable for PhD level
- **Prioritize conciseness**: Avoid unnecessary verbosity while maintaining completeness

### 2. When Updating Existing Notes
- Preserve existing structure when possible
- Add new content in appropriate sections
- Update links if note names change
- Maintain consistency with formatting rules
- **Apply conciseness improvements**: Restructure for better readability when beneficial

### 3. Quality Standards
- **Completeness**: Cover the topic thoroughly
- **Clarity**: Use clear, precise language
- **Accuracy**: Ensure mathematical correctness
- **Depth**: Provide PhD-level understanding
- **Consistency**: Follow established patterns
- **Conciseness**: Present information efficiently without loss of detail

## Error Prevention

### 1. Link Validation Checklist
- [ ] Note exists in `z_Obsidian Notes` directory
- [ ] Filename matches exactly (case-sensitive)
- [ ] No .md extension in link
- [ ] Link is relevant and meaningful

### 2. Formatting Checklist
- [ ] Proper Zettelkasten structure
- [ ] Correct LaTeX formatting
- [ ] Consistent section headers
- [ ] Comprehensive content coverage
- [ ] Appropriate academic level
- [ ] **Conciseness**: No excessive scrolling required
- [ ] **Scannability**: Easy to navigate and find information

## Examples

### Correct Link Usage
```markdown
- Connection to [[QuickSort]] for partitioning strategy
- Uses the same approach as [[Master Method]] for recurrences
- Related to [[Least Squares]] optimization
```

### Incorrect Link Usage (DO NOT DO)
```markdown
- Connection to [[Graph Theory]] (note doesn't exist)
- Uses [[Computational Complexity]] (note doesn't exist)
- Related to [[Numerical Analysis]] (note doesn't exist)
```

### Proper Note Structure (Concise Format)
```markdown
# Algorithm Name

Brief introduction and definition.

## Basic Idea
- Core concept explanation
- Key principles

## Algorithm Steps
1. **Step 1**: Description
2. **Step 2**: Description

## Time Complexity
- Analysis using proper LaTeX: $O(n \log n)$

## Applications
- Real-world uses
- Connection to [[Existing Note]]
```

### Improved Conciseness Examples
```markdown
## Performance & Indexing  # Combined related sections

### **Index Types**
- **B-tree**: Balanced structure for range queries ($O(\log n)$)
- **Hash**: Direct access for equality queries ($O(1)$)

## Query Processing & Optimization  # Merged sections

### **Execution Steps**
1. **Parsing** → **Validation** → **Optimization** → **Execution** → **Result**
```

## Enforcement
- **Always verify** before creating links
- **Use directory listing** to check note existence
- **Follow formatting** consistently
- **Maintain quality** standards
- **Prevent broken links** at all costs
- **Prioritize conciseness** for better user experience
- **Ensure scannability** without excessive scrolling

Remember: It's better to have no link than a broken link. When in doubt, omit the link and focus on creating comprehensive, well-formatted content. **Strive for conciseness while maintaining academic rigor and completeness.** 